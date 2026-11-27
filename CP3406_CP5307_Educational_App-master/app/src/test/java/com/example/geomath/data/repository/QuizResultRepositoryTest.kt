package com.example.geomath.data.repository

import com.example.geomath.data.local.FakeQuizResultDao
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class QuizResultRepositoryTest {

    @Test
    fun `saveResult calculates percentage correctly`() = runBlocking {
        val dao = FakeQuizResultDao()
        val repository = QuizResultRepository(dao)

        repository.saveResult(
            topic = "Triangles",
            difficulty = "Medium",
            score = 8,
            totalQuestions = 10,
            maxScore = 10
        )

        val results = dao.getAllResults().first()

        assertEquals(1, results.size)
        assertEquals("Triangles", results[0].topic)
        assertEquals("Medium", results[0].difficulty)
        assertEquals(8, results[0].score)
        assertEquals(10, results[0].totalQuestions)
        assertEquals(80, results[0].percentage)
    }

    @Test
    fun `saveResult calculates 100 percent for perfect score`() = runBlocking {
        val dao = FakeQuizResultDao()
        val repository = QuizResultRepository(dao)

        repository.saveResult(
            topic = "Circles",
            difficulty = "Hard",
            score = 30,
            totalQuestions = 3,
            maxScore = 30
        )

        val results = dao.getAllResults().first()

        assertEquals(100, results[0].percentage)
    }

    @Test
    fun `saveResult calculates zero percent for zero score`() = runBlocking {
        val dao = FakeQuizResultDao()
        val repository = QuizResultRepository(dao)

        repository.saveResult(
            topic = "Angles",
            difficulty = "Easy",
            score = 0,
            totalQuestions = 3,
            maxScore = 30
        )

        val results = dao.getAllResults().first()

        assertEquals(0, results[0].percentage)
    }

    @Test
    fun `saveResult handles zero maximum score`() = runBlocking {
        val dao = FakeQuizResultDao()
        val repository = QuizResultRepository(dao)

        repository.saveResult(
            topic = "Geometry",
            difficulty = "Easy",
            score = 0,
            totalQuestions = 0,
            maxScore = 0
        )

        val results = dao.getAllResults().first()

        assertEquals(0, results[0].percentage)
    }

    @Test
    fun `getResultsByTopic returns matching results`() = runBlocking {
        val dao = FakeQuizResultDao()
        val repository = QuizResultRepository(dao)

        repository.saveResult(
            topic = "Triangles",
            difficulty = "Easy",
            score = 8,
            totalQuestions = 10,
            maxScore = 10
        )

        repository.saveResult(
            topic = "Circles",
            difficulty = "Medium",
            score = 7,
            totalQuestions = 10,
            maxScore = 10
        )

        val triangleResults =
            repository.getResultsByTopic("Triangles").first()

        assertEquals(1, triangleResults.size)
        assertEquals("Triangles", triangleResults[0].topic)
    }

    @Test
    fun `deleteAllResults removes all saved results`() = runBlocking {
        val dao = FakeQuizResultDao()
        val repository = QuizResultRepository(dao)

        repository.saveResult(
            topic = "Triangles",
            difficulty = "Easy",
            score = 8,
            totalQuestions = 10,
            maxScore = 10
        )

        repository.saveResult(
            topic = "Circles",
            difficulty = "Medium",
            score = 9,
            totalQuestions = 10,
            maxScore = 10
        )

        repository.deleteAllResults()

        val results = repository.getAllResults().first()

        assertEquals(0, results.size)
    }
}