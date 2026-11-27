package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate

import retrofit2.http.GET

interface CurrencyApiService {
    @GET("latest/USD")
    suspend fun getRates() : ExchangeRateResponse
}