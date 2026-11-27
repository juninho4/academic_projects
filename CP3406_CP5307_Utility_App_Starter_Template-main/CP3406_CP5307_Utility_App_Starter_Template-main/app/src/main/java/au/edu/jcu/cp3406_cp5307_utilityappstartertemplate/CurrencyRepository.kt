package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate

class CurrencyRepository {
    suspend fun getRates(): ExchangeRateResponse {
        return RetrofitInstance.api.getRates()
    }
}