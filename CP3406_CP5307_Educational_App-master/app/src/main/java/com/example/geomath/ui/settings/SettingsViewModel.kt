package com.example.geomath.ui.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.geomath.data.repository.SettingsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        SettingsRepository(application)

    val soundEnabled: StateFlow<Boolean> =
        repository.soundEnabled.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            true
        )

    val darkModeEnabled: StateFlow<Boolean> =
        repository.darkModeEnabled.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            false
        )

    val difficulty: StateFlow<String> =
        repository.difficulty.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            "Medium"
        )

    val questionCount: StateFlow<Int> =
        repository.questionCount.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            10
        )

    fun setSoundEnabled(enabled: Boolean) {
        viewModelScope.launch {
            repository.setSoundEnabled(enabled)
        }
    }

    fun setDarkModeEnabled(enabled: Boolean) {
        viewModelScope.launch {
            repository.setDarkModeEnabled(enabled)
        }
    }

    fun setDifficulty(difficulty: String) {
        viewModelScope.launch {
            repository.setDifficulty(difficulty)
        }
    }

    fun setQuestionCount(count: Int) {
        viewModelScope.launch {
            repository.setQuestionCount(count)
        }
    }
}