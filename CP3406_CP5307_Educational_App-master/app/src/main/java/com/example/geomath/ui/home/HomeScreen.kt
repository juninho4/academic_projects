package com.example.geomath.ui.home

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    onStartQuiz: () -> Unit,
    onStatistics: () -> Unit,
    onSettings: () -> Unit,
    viewModel: GeometryFactViewModel = viewModel()
) {
    val fact = viewModel.fact.collectAsState().value
    val error = viewModel.error.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.loadTopic("Triangle")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "GeoMath",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Learn Geometry. Practise. Improve.",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Ready to practise?",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Geometry Spotlight",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                )

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        when {
                            isLoading -> {
                                Text(
                                    text = "Loading geometry information...",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }

                            error != null -> {
                                Text(
                                    text = error,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }

                            fact != null -> {
                                Text(
                                    text = fact.title ?: "Triangle",
                                    style = MaterialTheme.typography.headlineSmall,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                if (!fact.description.isNullOrBlank()) {
                                    Text(
                                        text = fact.description,
                                        style = MaterialTheme.typography.labelLarge
                                    )

                                    Spacer(modifier = Modifier.height(8.dp))
                                }

                                Text(
                                    text = fact.extract ?: "No information available.",
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(
                                    text = "Source: Wikipedia",
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Test your geometry knowledge with interactive questions and learn from your mistakes.",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = onStartQuiz,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Start Quiz")
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Your Progress",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Recent Accuracy",
                    style = MaterialTheme.typography.labelLarge
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "No quizzes completed yet",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Complete your first quiz to start tracking your progress.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = onStatistics,
                modifier = Modifier.weight(1f)
            ) {
                Text("Statistics")
            }

            OutlinedButton(
                onClick = onSettings,
                modifier = Modifier.weight(1f)
            ) {
                Text("Settings")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}