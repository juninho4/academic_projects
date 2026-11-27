package com.example.geomath.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WikipediaApiProvider {

    private const val BASE_URL =
        "https://en.wikipedia.org/"

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .header(
                    "User-Agent",
                    "GeoMath/1.0 (https://github.com/juninho4/CP3406_CP5307_Educational_App) OkHttp"
                )
                .header(
                    "Accept",
                    "application/json"
                )
                .build()

            chain.proceed(request)
        }
        .build()

    val api: WikipediaApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WikipediaApi::class.java)
    }
}