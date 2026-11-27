package com.example.geomath.ui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = viewModel()
) {
    val soundEnabled by viewModel.soundEnabled.collectAsState()

    val darkModeEnabled by viewModel.darkModeEnabled.collectAsState()

    val selectedDifficulty by viewModel.difficulty.collectAsState()

    val selectedQuestionCount by viewModel.questionCount.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Quiz",
            style = MaterialTheme.typography.titleMedium
        )

        HorizontalDivider()

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Default Difficulty",
            style = MaterialTheme.typography.titleSmall
        )

        DifficultyOption(
            text = "Easy",
            selected = selectedDifficulty == "Easy",
            onClick = {
                viewModel.setDifficulty("Easy")
            }
        )

        DifficultyOption(
            text = "Medium",
            selected = selectedDifficulty == "Medium",
            onClick = {
                viewModel.setDifficulty("Medium")
            }
        )

        DifficultyOption(
            text = "Hard",
            selected = selectedDifficulty == "Hard",
            onClick = {
                viewModel.setDifficulty("Hard")
            }
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Questions per Quiz",
            style = MaterialTheme.typography.titleSmall
        )

        QuestionCountOption(
            count = 5,
            selected = selectedQuestionCount == 5,
            onClick = {
                viewModel.setQuestionCount(5)
            }
        )

        QuestionCountOption(
            count = 10,
            selected = selectedQuestionCount == 10,
            onClick = {
                viewModel.setQuestionCount(10)
            }
        )

        QuestionCountOption(
            count = 15,
            selected = selectedQuestionCount == 15,
            onClick = {
                viewModel.setQuestionCount(15)
            }
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        SettingSwitch(
            title = "Sound Effects",
            checked = soundEnabled,
            onCheckedChange = {
                viewModel.setSoundEnabled(it)
            }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Appearance",
            style = MaterialTheme.typography.titleMedium
        )

        HorizontalDivider()

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        SettingSwitch(
            title = "Dark Mode",
            checked = darkModeEnabled,
            onCheckedChange = {
                viewModel.setDarkModeEnabled(it)
            }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "About",
            style = MaterialTheme.typography.titleMedium
        )

        HorizontalDivider()

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "GeoMath",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = "Geometry learning for secondary students.",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Version 1.0",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun DifficultyOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        RadioButton(
            selected = selected,
            onClick = onClick
        )

        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun QuestionCountOption(
    count: Int,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        RadioButton(
            selected = selected,
            onClick = onClick
        )

        Text(
            text = "$count questions",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun SettingSwitch(
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge
        )

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}