package com.example.geomath.data.repository

import android.content.Context
import com.example.geomath.data.local.GeoMathDatabase

object RepositoryProvider {

    fun provideQuizResultRepository(
        context: Context
    ): QuizResultRepository {

        val database = GeoMathDatabase.getDatabase(context)

        return QuizResultRepository(
            database.quizResultDao()
        )
    }
}