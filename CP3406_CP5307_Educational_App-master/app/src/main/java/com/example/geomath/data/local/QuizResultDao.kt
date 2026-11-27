package com.example.geomath.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizResultDao {

    @Insert
    suspend fun insertResult(result: QuizResultEntity)

    @Query("SELECT * FROM quiz_results ORDER BY completedAt DESC")
    fun getAllResults(): Flow<List<QuizResultEntity>>

    @Query(
        "SELECT * FROM quiz_results " +
                "WHERE topic = :topic " +
                "ORDER BY completedAt DESC"
    )
    fun getResultsByTopic(
        topic: String
    ): Flow<List<QuizResultEntity>>

    @Query("DELETE FROM quiz_results")
    suspend fun deleteAllResults()
}