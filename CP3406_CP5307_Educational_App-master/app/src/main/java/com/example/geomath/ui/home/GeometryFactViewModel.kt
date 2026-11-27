package com.example.geomath.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geomath.data.remote.WikipediaApiProvider
import com.example.geomath.data.remote.WikipediaSummary
import com.example.geomath.data.repository.GeometryFactRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GeometryFactViewModel : ViewModel() {

    private val repository = GeometryFactRepository(
        WikipediaApiProvider.api
    )

    private val _fact = MutableStateFlow<WikipediaSummary?>(null)
    val fact: StateFlow<WikipediaSummary?> = _fact.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun loadTopic(topic: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            repository.getGeometryTopic(topic)
                .onSuccess {
                    _fact.value = it
                }
                .onFailure { exception ->
                    android.util.Log.e(
                        "GeoMathAPI",
                        "Failed to load geometry information",
                        exception
                    )

                    _error.value =
                        "Unable to load geometry information: ${exception.message}"
                }

            _isLoading.value = false
        }
    }
}