package com.example.geomath.navigation

sealed class Screen(val route: String) {

    data object Home : Screen("home")

    data object QuizSetup : Screen("quiz_setup")

    data object Quiz : Screen(
        "quiz/{topic}/{difficulty}/{questionCount}"
    )

    data object Results : Screen(
        "results/{score}/{totalQuestions}"
    )

    data object Statistics : Screen("statistics")

    data object Settings : Screen("settings")
}