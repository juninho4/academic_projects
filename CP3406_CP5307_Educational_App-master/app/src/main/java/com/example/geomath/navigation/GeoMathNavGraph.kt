package com.example.geomath.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.geomath.ui.home.HomeScreen
import com.example.geomath.ui.quiz.QuizScreen
import com.example.geomath.ui.results.ResultsScreen
import com.example.geomath.ui.settings.SettingsScreen
import com.example.geomath.ui.statistics.StatisticsScreen
import com.example.geomath.ui.quiz.QuizSetupScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.geomath.ui.quiz.QuizViewModel
import com.example.geomath.ui.quiz.QuizViewModelFactory

import com.example.geomath.ui.statistics.StatisticsViewModel
import com.example.geomath.ui.statistics.StatisticsViewModelFactory

@Composable
fun GeoMathNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(
                onStartQuiz = {
                    navController.navigate(Screen.QuizSetup.route)
                },
                onStatistics = {
                    navController.navigate(Screen.Statistics.route)
                },
                onSettings = {
                    navController.navigate(Screen.Settings.route)
                }
            )
        }

        composable(
            route = Screen.Quiz.route,
            arguments = listOf(
                navArgument("topic") {
                    type = NavType.StringType
                },
                navArgument("difficulty") {
                    type = NavType.StringType
                },
                navArgument("questionCount") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val context = LocalContext.current

            val viewModel: QuizViewModel = viewModel(
                viewModelStoreOwner = backStackEntry,
                factory = QuizViewModelFactory(
                    context = context,
                    savedStateHandle = backStackEntry.savedStateHandle
                )
            )

            QuizScreen(
                viewModel = viewModel,
                onQuizFinished = { score, totalQuestions ->

                    navController.navigate(
                        "results/$score/$totalQuestions"
                    )
                }
            )
        }

        composable(Screen.QuizSetup.route) {
            QuizSetupScreen(
                onStartQuiz = { topic, difficulty, questionCount ->

                    val encodedTopic = android.net.Uri.encode(topic)
                    val encodedDifficulty = android.net.Uri.encode(difficulty)

                    navController.navigate(
                        "quiz/$encodedTopic/$encodedDifficulty/$questionCount"
                    )
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screen.Results.route,
            arguments = listOf(
                navArgument("score") {
                    type = NavType.IntType
                },
                navArgument("totalQuestions") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val score =
                backStackEntry.arguments?.getInt("score") ?: 0

            val totalQuestions =
                backStackEntry.arguments?.getInt("totalQuestions") ?: 0

            ResultsScreen(
                score = score,
                totalQuestions = totalQuestions,
                onBackToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.Statistics.route) { backStackEntry ->

            val context = LocalContext.current

            val viewModel: StatisticsViewModel = viewModel(
                viewModelStoreOwner = backStackEntry,
                factory = StatisticsViewModelFactory(
                    context = context,
                    savedStateHandle = backStackEntry.savedStateHandle
                )
            )

            StatisticsScreen(
                viewModel = viewModel
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen()
        }
    }
}