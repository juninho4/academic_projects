package com.example.geomath.ui.statistics

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.geomath.data.repository.RepositoryProvider

class StatisticsViewModelFactory(
    private val context: Context,
    private val savedStateHandle: SavedStateHandle
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(StatisticsViewModel::class.java)) {

            val repository =
                RepositoryProvider.provideQuizResultRepository(context)

            return StatisticsViewModel(
                repository = repository
            ) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class"
        )
    }
}