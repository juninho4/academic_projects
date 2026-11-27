package com.example.geomath.data.repository

import com.example.geomath.data.local.QuizResultDao
import com.example.geomath.data.local.QuizResultEntity
import kotlinx.coroutines.flow.Flow

class QuizResultRepository(
    private val dao: QuizResultDao
) {

    suspend fun saveResult(
        topic: String,
        difficulty: String,
        score: Int,
        totalQuestions: Int,
        maxScore: Int
    ) {
        val percentage =
            if (maxScore > 0) {
                ((score.toFloat() / maxScore) * 100).toInt()
            } else {
                0
            }

        dao.insertResult(
            QuizResultEntity(
                topic = topic,
                difficulty = difficulty,
                score = score,
                totalQuestions = totalQuestions,
                percentage = percentage
            )
        )
    }

    fun getAllResults(): Flow<List<QuizResultEntity>> {
        return dao.getAllResults()
    }

    fun getResultsByTopic(
        topic: String
    ): Flow<List<QuizResultEntity>> {
        return dao.getResultsByTopic(topic)
    }

    suspend fun deleteAllResults() {
        dao.deleteAllResults()
    }
}