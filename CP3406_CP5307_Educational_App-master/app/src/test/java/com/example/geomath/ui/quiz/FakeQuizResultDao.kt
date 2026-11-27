package com.example.geomath.data.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeQuizResultDao : QuizResultDao {

    private val results = MutableStateFlow<List<QuizResultEntity>>(emptyList())

    override suspend fun insertResult(result: QuizResultEntity) {
        results.value = results.value + result
    }

    override fun getAllResults(): Flow<List<QuizResultEntity>> {
        return results
    }

    override fun getResultsByTopic(
        topic: String
    ): Flow<List<QuizResultEntity>> {
        return MutableStateFlow(
            results.value.filter { it.topic == topic }
        )
    }

    override suspend fun deleteAllResults() {
        results.value = emptyList()
    }
}