package com.example.geomath.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface WikipediaApi {

    @GET("api/rest_v1/page/summary/{title}")
    suspend fun getSummary(
        @Path("title") title: String
    ): WikipediaSummary
}