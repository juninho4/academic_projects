package com.example.geomath.ui.quiz

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.geomath.data.repository.RepositoryProvider

class QuizViewModelFactory(
    private val context: Context,
    private val savedStateHandle: SavedStateHandle
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {

            val repository =
                RepositoryProvider.provideQuizResultRepository(context)

            return QuizViewModel(
                savedStateHandle = savedStateHandle,
                repository = repository
            ) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class"
        )
    }
}