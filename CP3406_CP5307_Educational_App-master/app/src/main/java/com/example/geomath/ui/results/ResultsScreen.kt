package com.example.geomath.ui.results

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun ResultsScreen(
    score: Int,
    totalQuestions: Int,
    onBackToHome: () -> Unit
) {

    val maxScore = totalQuestions * 10

    val percentage =
        if (maxScore > 0) {
            ((score.toFloat() / maxScore) * 100).roundToInt()
        } else {
            0
        }

    val correctAnswers = score / 10
    val incorrectAnswers = totalQuestions - correctAnswers

    val message = when {
        percentage >= 80 ->
            "Excellent work! You have a strong understanding of geometry."

        percentage >= 60 ->
            "Good job! Keep practising to strengthen your geometry skills."

        percentage >= 40 ->
            "You're making progress. Review the explanations and try again."

        else ->
            "Keep practising! Every attempt helps you improve."
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Quiz Complete!",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(28.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "$percentage%",
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Score: $score / $maxScore",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Correct answers: $correctAnswers",
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = "Incorrect answers: $incorrectAnswers",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = onBackToHome,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Home")
        }
    }
}