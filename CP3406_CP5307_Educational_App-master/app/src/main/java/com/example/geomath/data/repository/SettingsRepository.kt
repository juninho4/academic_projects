package com.example.geomath.data.repository

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.settingsDataStore by preferencesDataStore(
    name = "geomath_settings"
)

class SettingsRepository(
    private val context: Context
) {

    companion object {
        private val SOUND_ENABLED =
            booleanPreferencesKey("sound_enabled")

        private val DARK_MODE_ENABLED =
            booleanPreferencesKey("dark_mode_enabled")

        private val DIFFICULTY =
            stringPreferencesKey("difficulty")

        private val QUESTION_COUNT =
            intPreferencesKey("question_count")
    }

    val soundEnabled: Flow<Boolean> =
        context.settingsDataStore.data.map { preferences ->
            preferences[SOUND_ENABLED] ?: true
        }

    val darkModeEnabled: Flow<Boolean> =
        context.settingsDataStore.data.map { preferences ->
            preferences[DARK_MODE_ENABLED] ?: false
        }

    val difficulty: Flow<String> =
        context.settingsDataStore.data.map { preferences ->
            preferences[DIFFICULTY] ?: "Medium"
        }

    val questionCount: Flow<Int> =
        context.settingsDataStore.data.map { preferences ->
            preferences[QUESTION_COUNT] ?: 10
        }

    suspend fun setSoundEnabled(enabled: Boolean) {
        context.settingsDataStore.edit { preferences ->
            preferences[SOUND_ENABLED] = enabled
        }
    }

    suspend fun setDarkModeEnabled(enabled: Boolean) {
        context.settingsDataStore.edit { preferences ->
            preferences[DARK_MODE_ENABLED] = enabled
        }
    }

    suspend fun setDifficulty(difficulty: String) {
        context.settingsDataStore.edit { preferences ->
            preferences[DIFFICULTY] = difficulty
        }
    }

    suspend fun setQuestionCount(count: Int) {
        context.settingsDataStore.edit { preferences ->
            preferences[QUESTION_COUNT] = count
        }
    }
}