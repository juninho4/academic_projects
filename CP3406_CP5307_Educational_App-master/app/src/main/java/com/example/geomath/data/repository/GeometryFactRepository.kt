package com.example.geomath.data.repository

import com.example.geomath.data.remote.WikipediaApi
import com.example.geomath.data.remote.WikipediaSummary

class GeometryFactRepository(
    private val api: WikipediaApi
) {

    suspend fun getGeometryTopic(
        topic: String
    ): Result<WikipediaSummary> {
        return try {
            Result.success(api.getSummary(topic))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}