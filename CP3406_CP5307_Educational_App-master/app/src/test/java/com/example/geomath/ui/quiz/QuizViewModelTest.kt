package com.example.geomath.ui.quiz

import androidx.lifecycle.SavedStateHandle
import com.example.geomath.data.local.QuizResultDao
import com.example.geomath.data.local.QuizResultEntity
import com.example.geomath.data.repository.QuizResultRepository
import com.example.geomath.data.local.FakeQuizResultDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

private class FakeQuizResultDao : QuizResultDao {

    override suspend fun insertResult(result: QuizResultEntity) {
        // Nothing needed for these tests
    }

    override fun getAllResults(): Flow<List<QuizResultEntity>> {
        return emptyFlow()
    }

    override fun getResultsByTopic(
        topic: String
    ): Flow<List<QuizResultEntity>> {
        return emptyFlow()
    }

    override suspend fun deleteAllResults() {
        // Nothing needed for these tests
    }
}

class QuizViewModelTest {

    private fun createViewModel(
        topic: String = "Triangles",
        difficulty: String = "Medium",
        questionCount: Int = 1
    ): QuizViewModel {

        val savedStateHandle = SavedStateHandle(
            mapOf(
                "topic" to topic,
                "difficulty" to difficulty,
                "questionCount" to questionCount
            )
        )

        val repository = QuizResultRepository(
            FakeQuizResultDao()
        )

        return QuizViewModel(
            savedStateHandle = savedStateHandle,
            repository = repository
        )
    }

    @Test
    fun `initial quiz state is correct`() {
        val viewModel = createViewModel()

        assertEquals(0, viewModel.currentQuestionIndex)
        assertEquals(0, viewModel.score)
        assertNull(viewModel.selectedAnswer)
        assertFalse(viewModel.answerSubmitted)
        assertEquals("1 / 1", viewModel.getProgress())
    }

    @Test
    fun `selecting an answer updates selected answer`() {
        val viewModel = createViewModel()

        viewModel.selectAnswer("55°")

        assertEquals("55°", viewModel.selectedAnswer)
    }

    @Test
    fun `correct answer increases score`() {
        val viewModel = createViewModel()

        viewModel.selectAnswer("55°")
        viewModel.submitAnswer()

        assertEquals(10, viewModel.score)
        assertTrue(viewModel.answerSubmitted)
        assertTrue(viewModel.isCorrect())
    }

    @Test
    fun `incorrect answer does not increase score`() {
        val viewModel = createViewModel()

        viewModel.selectAnswer("45°")
        viewModel.submitAnswer()

        assertEquals(0, viewModel.score)
        assertTrue(viewModel.answerSubmitted)
        assertFalse(viewModel.isCorrect())
    }

    @Test
    fun `answer cannot be changed after submission`() {
        val viewModel = createViewModel()

        viewModel.selectAnswer("55°")
        viewModel.submitAnswer()

        viewModel.selectAnswer("45°")

        assertEquals("55°", viewModel.selectedAnswer)
    }

    @Test
    fun `answer cannot be submitted twice`() {
        val viewModel = createViewModel()

        viewModel.selectAnswer("55°")
        viewModel.submitAnswer()
        viewModel.submitAnswer()

        assertEquals(10, viewModel.score)
    }

    @Test
    fun `cannot submit without selecting an answer`() {
        val viewModel = createViewModel()

        viewModel.submitAnswer()

        assertEquals(0, viewModel.score)
        assertFalse(viewModel.answerSubmitted)
    }

    @Test
    fun `quiz is complete after final question is submitted`() {
        val viewModel = createViewModel()

        viewModel.selectAnswer("55°")
        viewModel.submitAnswer()

        assertTrue(viewModel.isQuizComplete())
    }

    @Test
    fun `next question resets answer state`() {
        val viewModel = createViewModel(
            topic = "Angles",
            difficulty = "Easy",
            questionCount = 2
        )

        viewModel.selectAnswer("55°")
        viewModel.submitAnswer()
        viewModel.nextQuestion()

        assertEquals(1, viewModel.currentQuestionIndex)
        assertNull(viewModel.selectedAnswer)
        assertFalse(viewModel.answerSubmitted)
        assertEquals("2 / 2", viewModel.getProgress())
    }
}