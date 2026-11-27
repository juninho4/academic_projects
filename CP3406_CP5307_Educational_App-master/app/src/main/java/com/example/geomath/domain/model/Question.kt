package com.example.geomath.domain.model

data class Question(
    val id: Int,
    val topic: String,
    val difficulty: String,
    val questionText: String,
    val options: List<String>,
    val correctAnswer: String,
    val explanation: String,
    val points: Int = 10
)