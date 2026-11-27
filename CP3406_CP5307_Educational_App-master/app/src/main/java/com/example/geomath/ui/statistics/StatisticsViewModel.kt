package com.example.geomath.ui.statistics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geomath.data.local.QuizResultEntity
import com.example.geomath.data.repository.QuizResultRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class TopicPerformance(
    val topic: String,
    val averagePercentage: Int
)

class StatisticsViewModel(
    repository: QuizResultRepository
) : ViewModel() {

    val results: StateFlow<List<QuizResultEntity>> =
        repository.getAllResults()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    val quizCount: StateFlow<Int> =
        results
            .map { it.size }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                0
            )

    val averagePercentage: StateFlow<Int> =
        results
            .map { resultList ->
                if (resultList.isEmpty()) {
                    0
                } else {
                    resultList
                        .map { it.percentage }
                        .average()
                        .toInt()
                }
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                0
            )

    val bestPercentage: StateFlow<Int> =
        results
            .map { resultList ->
                resultList.maxOfOrNull { it.percentage } ?: 0
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                0
            )

    val totalQuestions: StateFlow<Int> =
        results
            .map { resultList ->
                resultList.sumOf { it.totalQuestions }
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                0
            )

    val topicPerformance: StateFlow<List<TopicPerformance>> =
        results
            .map { resultList ->

                resultList
                    .groupBy { it.topic }
                    .map { (topic, topicResults) ->

                        val average =
                            topicResults
                                .map { it.percentage }
                                .average()
                                .toInt()

                        TopicPerformance(
                            topic = topic,
                            averagePercentage = average
                        )
                    }
                    .sortedBy { it.topic }
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                emptyList()
            )
}