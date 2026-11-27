package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CurrencyViewModel : ViewModel() {
    private val repository = CurrencyRepository()
    var result by mutableStateOf("0.00")
        private set
    var isLoading by mutableStateOf(false)
        private set

    fun convert(amount: Double, from: String, to: String) {
        viewModelScope.launch {
            isLoading = true

            val rates = repository.getRates()

            val fromRate = rates.conversion_rates[from] ?: 1.0
            val toRate = rates.conversion_rates[to] ?: 1.0

            val converted = (amount / fromRate) * toRate

            result = converted.toString()
            isLoading = false
        }
    }
}