package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate

data class ExchangeRateResponse(
    val base_code: String,
    val conversion_rates: Map<String, Double>
)