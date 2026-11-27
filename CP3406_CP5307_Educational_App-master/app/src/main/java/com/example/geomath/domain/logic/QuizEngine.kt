package com.example.geomath.domain.logic

import com.example.geomath.domain.model.Question

class QuizEngine(
    questions: List<Question>,
    topic: String,
    difficulty: String,
    questionCount: Int
) {

    val selectedQuestions: List<Question> =
        questions
            .filter { question ->
                val topicMatches =
                    topic == "Mixed Geometry" ||
                            question.topic == topic

                val difficultyMatches =
                    question.difficulty == difficulty

                topicMatches && difficultyMatches
            }
            .shuffled()
            .take(questionCount)
}