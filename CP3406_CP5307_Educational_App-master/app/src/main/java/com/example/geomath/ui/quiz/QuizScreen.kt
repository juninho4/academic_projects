package com.example.geomath.ui.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.geomath.ui.settings.SettingsViewModel

import androidx.compose.runtime.remember

@Composable
fun QuizScreen(
    onQuizFinished: (score: Int, totalQuestions: Int) -> Unit,
    viewModel: QuizViewModel,
    settingsViewModel: SettingsViewModel = viewModel()
){
    val soundEnabled by settingsViewModel.soundEnabled
        .collectAsStateWithLifecycle()

    val quizSound = remember {
        QuizSound()
    }

    DisposableEffect(Unit) {
        onDispose {
            quizSound.release()
        }
    }

    LaunchedEffect(viewModel.answerSubmitted) {

        if (viewModel.answerSubmitted && soundEnabled) {

            if (viewModel.isCorrect()) {
                quizSound.playCorrect()
            } else {
                quizSound.playIncorrect()
            }
        }
    }

    val question = viewModel.currentQuestion

    if (question == null) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "No questions are available for this selection.",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = question.topic,
            style = MaterialTheme.typography.labelLarge
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Question ${viewModel.getProgress()}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = question.questionText,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        question.options.forEach { option ->

            val selected = viewModel.selectedAnswer == option

            if (selected) {
                Button(
                    onClick = {
                        viewModel.selectAnswer(option)
                    },
                    enabled = !viewModel.answerSubmitted,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {
                    Text(option)
                }
            } else {
                OutlinedButton(
                    onClick = {
                        viewModel.selectAnswer(option)
                    },
                    enabled = !viewModel.answerSubmitted,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {
                    Text(option)
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (!viewModel.answerSubmitted) {

            Button(
                onClick = {
                    viewModel.submitAnswer()
                },
                enabled = viewModel.selectedAnswer != null,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit Answer")
            }

        } else {

            val correct = viewModel.isCorrect()

            Text(
                text = if (correct) {
                    "✓ Correct!"
                } else {
                    "✗ Not quite."
                },
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (!correct) {
                Text(
                    text = "Correct answer: ${question.correctAnswer}",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(8.dp))
            }

            Text(
                text = question.explanation,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    if (viewModel.isQuizComplete()) {

                        viewModel.saveQuizResult()

                        onQuizFinished(
                            viewModel.score,
                            viewModel.questions.size
                        )
                    } else {
                        viewModel.nextQuestion()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    if (viewModel.isQuizComplete()) {
                        "Finish Quiz"
                    } else {
                        "Next Question"
                    }
                )
            }
        }
    }
}