package com.example.geomath.ui.quiz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.geomath.data.local.QuestionBank
import com.example.geomath.domain.logic.QuizEngine
import com.example.geomath.domain.model.Question

import com.example.geomath.data.repository.QuizResultRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class QuizViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: QuizResultRepository? = null
) : ViewModel() {

    val topic: String =
        savedStateHandle["topic"] ?: "Mixed Geometry"

    val difficulty: String =
        savedStateHandle["difficulty"] ?: "Medium"

    val questionCount: Int =
        savedStateHandle["questionCount"] ?: 10

    private val engine = QuizEngine(
        questions = QuestionBank.questions,
        topic = topic,
        difficulty = difficulty,
        questionCount = questionCount
    )

    val questions: List<Question> =
        engine.selectedQuestions

    var currentQuestionIndex by mutableIntStateOf(0)
        private set

    var score by mutableIntStateOf(0)
        private set

    var selectedAnswer by mutableStateOf<String?>(null)
        private set

    var answerSubmitted by mutableStateOf(false)
        private set

    val currentQuestion: Question?
        get() = questions.getOrNull(currentQuestionIndex)

    fun selectAnswer(answer: String) {
        if (!answerSubmitted) {
            selectedAnswer = answer
        }
    }

    fun submitAnswer() {
        if (selectedAnswer == null || answerSubmitted) {
            return
        }

        if (selectedAnswer == currentQuestion?.correctAnswer) {
            score += currentQuestion?.points ?: 0
        }

        answerSubmitted = true
    }

    fun nextQuestion() {
        if (!answerSubmitted) {
            return
        }

        if (currentQuestionIndex < questions.lastIndex) {
            currentQuestionIndex++
            selectedAnswer = null
            answerSubmitted = false
        }
    }

    fun isQuizComplete(): Boolean {
        return answerSubmitted &&
                currentQuestionIndex == questions.lastIndex
    }

    fun isCorrect(): Boolean {
        return selectedAnswer == currentQuestion?.correctAnswer
    }

    fun getProgress(): String {
        if (questions.isEmpty()) {
            return "0 / 0"
        }

        return "${currentQuestionIndex + 1} / ${questions.size}"
    }

    fun saveQuizResult() {
        repository ?: return

        viewModelScope.launch {
            val maxScore = questions.sumOf { it.points }

            repository.saveResult(
                topic = topic,
                difficulty = difficulty,
                score = score,
                totalQuestions = questions.size,
                maxScore = maxScore
            )
        }
    }
}