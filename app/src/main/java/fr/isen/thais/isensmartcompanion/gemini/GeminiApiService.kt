package fr.isen.thais.isensmartcompanion.gemini

import fr.isen.thais.isensmartcompanion.model.GeminiRequest
import fr.isen.thais.isensmartcompanion.model.GeminiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface GeminiApiService {
    @POST("v1beta/models/gemini-pro:generateContent")
    suspend fun generateContent(
        @Query("key") apiKey: String,
        @Body request: GeminiRequest
    ): Response<GeminiResponse>
}
