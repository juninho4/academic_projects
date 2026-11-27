package com.example.geomath.ui.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.geomath.ui.settings.SettingsViewModel

@Composable
fun QuizSetupScreen(
    onStartQuiz: (
        topic: String,
        difficulty: String,
        questionCount: Int
    ) -> Unit,
    onBack: () -> Unit,
    settingsViewModel: SettingsViewModel = viewModel()
) {
    val defaultDifficulty by
    settingsViewModel.difficulty.collectAsStateWithLifecycle()

    val defaultQuestionCount by
    settingsViewModel.questionCount.collectAsStateWithLifecycle()

    val topics = listOf(
        "Angles",
        "Triangles",
        "Quadrilaterals",
        "Area & Perimeter",
        "Circles",
        "Volume",
        "Mixed Geometry"
    )

    val difficulties = listOf(
        "Easy",
        "Medium",
        "Hard"
    )

    val questionCounts = listOf(5, 10, 15)

    var selectedTopic by remember {
        mutableStateOf(topics.first())
    }

    var selectedDifficulty by remember {
        mutableStateOf(defaultDifficulty)
    }

    var selectedQuestionCount by remember {
        mutableIntStateOf(defaultQuestionCount)
    }

    LaunchedEffect(defaultDifficulty) {
        selectedDifficulty = defaultDifficulty
    }

    LaunchedEffect(defaultQuestionCount) {
        selectedQuestionCount = defaultQuestionCount
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {

        Text(
            text = "Quiz Setup",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Choose how you want to practise geometry.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "Topic",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        topics.forEach { topic ->
            FilterChip(
                selected = selectedTopic == topic,
                onClick = {
                    selectedTopic = topic
                },
                label = {
                    Text(topic)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Difficulty",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            difficulties.forEach { difficulty ->
                FilterChip(
                    selected = selectedDifficulty == difficulty,
                    onClick = {
                        selectedDifficulty = difficulty
                    },
                    label = {
                        Text(difficulty)
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Number of Questions",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            questionCounts.forEach { count ->
                FilterChip(
                    selected = selectedQuestionCount == count,
                    onClick = {
                        selectedQuestionCount = count
                    },
                    label = {
                        Text("$count")
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                onStartQuiz(
                    selectedTopic,
                    selectedDifficulty,
                    selectedQuestionCount
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Start Quiz")
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}