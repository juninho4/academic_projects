package com.example.geomath.ui.statistics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun StatisticsScreen(
    viewModel: StatisticsViewModel
) {

    val results by viewModel.results.collectAsStateWithLifecycle()
    val quizCount by viewModel.quizCount.collectAsStateWithLifecycle()
    val averagePercentage by viewModel.averagePercentage.collectAsStateWithLifecycle()
    val bestPercentage by viewModel.bestPercentage.collectAsStateWithLifecycle()
    val totalQuestions by viewModel.totalQuestions.collectAsStateWithLifecycle()
    val topicPerformance by viewModel.topicPerformance.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {

            Text(
                text = "GeoMath Statistics",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }

        item {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                StatisticCard(
                    title = "Quizzes",
                    value = quizCount.toString(),
                    modifier = Modifier.weight(1f)
                )

                StatisticCard(
                    title = "Average",
                    value = "$averagePercentage%",
                    modifier = Modifier.weight(1f)
                )
            }
        }

        item {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                StatisticCard(
                    title = "Best Score",
                    value = "$bestPercentage%",
                    modifier = Modifier.weight(1f)
                )

                StatisticCard(
                    title = "Questions",
                    value = totalQuestions.toString(),
                    modifier = Modifier.weight(1f)
                )
            }
        }

        item {

            Text(
                text = "Topic Performance",
                style = MaterialTheme.typography.titleLarge
            )
        }

        if (topicPerformance.isEmpty()) {

            item {

                Text(
                    text = "Complete a quiz to see topic performance.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

        } else {

            items(topicPerformance) { performance ->

                TopicPerformanceCard(
                    performance = performance
                )
            }
        }

        item {

            Text(
                text = "Recent Attempts",
                style = MaterialTheme.typography.titleLarge
            )
        }

        if (results.isEmpty()) {

            item {

                Text(
                    text = "No quizzes completed yet.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

        } else {

            items(results) { result ->

                QuizResultCard(result)
            }
        }
    }
}

@Composable
private fun StatisticCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
private fun QuizResultCard(
    result: com.example.geomath.data.local.QuizResultEntity
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = result.topic,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Difficulty: ${result.difficulty}"
            )

            Text(
                text = "Score: ${result.percentage}%"
            )

            Text(
                text = "${result.totalQuestions} questions"
            )
        }
    }
}

@Composable
private fun TopicPerformanceCard(
    performance: TopicPerformance
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = performance.topic,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "${performance.averagePercentage}%",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            androidx.compose.material3.LinearProgressIndicator(
                progress = {
                    performance.averagePercentage / 100f
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}