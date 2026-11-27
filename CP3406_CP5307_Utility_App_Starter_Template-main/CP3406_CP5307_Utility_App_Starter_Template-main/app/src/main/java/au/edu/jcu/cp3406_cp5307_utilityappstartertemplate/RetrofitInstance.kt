package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL =
        "https://v6.exchangerate-api.com/v6/785150a8cde27184a3f6a2cc/"

    val api: CurrencyApiService by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(CurrencyApiService::class.java)
    }
}