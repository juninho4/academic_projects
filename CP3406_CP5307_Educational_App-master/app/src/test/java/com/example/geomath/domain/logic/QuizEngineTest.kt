package com.example.geomath.domain.logic

import com.example.geomath.domain.model.Question
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class QuizEngineTest {

    private val testQuestions = listOf(
        Question(
            id = 1,
            topic = "Triangle",
            difficulty = "Easy",
            questionText = "How many sides does a triangle have?",
            options = listOf("2", "3", "4", "5"),
            correctAnswer = "3",
            explanation = "A triangle has three sides."
        ),
        Question(
            id = 2,
            topic = "Triangle",
            difficulty = "Medium",
            questionText = "What is the sum of angles in a triangle?",
            options = listOf("90°", "180°", "270°", "360°"),
            correctAnswer = "180°",
            explanation = "The interior angles of a triangle add up to 180°."
        ),
        Question(
            id = 3,
            topic = "Circle",
            difficulty = "Easy",
            questionText = "What is the distance from the centre to the edge of a circle?",
            options = listOf("Diameter", "Radius", "Chord", "Circumference"),
            correctAnswer = "Radius",
            explanation = "The radius is the distance from the centre to the circumference."
        ),
        Question(
            id = 4,
            topic = "Circle",
            difficulty = "Medium",
            questionText = "What is the formula for the area of a circle?",
            options = listOf(
                "2πr",
                "πr²",
                "πd",
                "r²"
            ),
            correctAnswer = "πr²",
            explanation = "The area of a circle is π multiplied by the radius squared."
        ),
        Question(
            id = 5,
            topic = "Quadrilateral",
            difficulty = "Easy",
            questionText = "How many sides does a quadrilateral have?",
            options = listOf("3", "4", "5", "6"),
            correctAnswer = "4",
            explanation = "A quadrilateral has four sides."
        )
    )

    @Test
    fun `engine filters questions by topic`() {
        val engine = QuizEngine(
            questions = testQuestions,
            topic = "Triangle",
            difficulty = "Easy",
            questionCount = 10
        )

        assertEquals(1, engine.selectedQuestions.size)
        assertTrue(
            engine.selectedQuestions.all {
                it.topic == "Triangle"
            }
        )
    }

    @Test
    fun `engine filters questions by difficulty`() {
        val engine = QuizEngine(
            questions = testQuestions,
            topic = "Circle",
            difficulty = "Medium",
            questionCount = 10
        )

        assertEquals(1, engine.selectedQuestions.size)
        assertTrue(
            engine.selectedQuestions.all {
                it.difficulty == "Medium"
            }
        )
    }

    @Test
    fun `mixed geometry includes questions from multiple topics`() {
        val engine = QuizEngine(
            questions = testQuestions,
            topic = "Mixed Geometry",
            difficulty = "Easy",
            questionCount = 10
        )

        assertEquals(3, engine.selectedQuestions.size)

        val topics = engine.selectedQuestions
            .map { it.topic }
            .toSet()

        assertEquals(
            setOf("Triangle", "Circle", "Quadrilateral"),
            topics
        )
    }

    @Test
    fun `engine limits number of selected questions`() {
        val engine = QuizEngine(
            questions = testQuestions,
            topic = "Mixed Geometry",
            difficulty = "Easy",
            questionCount = 2
        )

        assertEquals(2, engine.selectedQuestions.size)
    }

    @Test
    fun `engine returns fewer questions when not enough questions match`() {
        val engine = QuizEngine(
            questions = testQuestions,
            topic = "Triangle",
            difficulty = "Easy",
            questionCount = 10
        )

        assertTrue(engine.selectedQuestions.size <= 10)
    }
}