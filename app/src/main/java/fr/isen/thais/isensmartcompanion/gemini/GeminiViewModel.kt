package fr.isen.thais.isensmartcompanion.gemini.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.isen.thais.isensmartcompanion.gemini.RetrofitClient
import fr.isen.thais.isensmartcompanion.model.GeminiRequest
import fr.isen.thais.isensmartcompanion.model.HistoryItem
import fr.isen.thais.isensmartcompanion.repository.HistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class GeminiViewModel() : ViewModel() {

    private val _response = MutableStateFlow<String?>(null)
    val response = _response.asStateFlow()

    private val apiKey = "AIzaSyCLirJv3jiVfRO_uo8l1ZFZFepH9enkOLs"

    fun sendRequest(userInput: String) {
        viewModelScope.launch {
            val request = GeminiRequest(
                contents = listOf(
                    GeminiRequest.Content(
                        parts = listOf(GeminiRequest.Part(text = userInput))
                    )
                )
            )

            try {
                val result = RetrofitClient.instance.generateContent(apiKey, request)
                if (result.isSuccessful) {
                    val textResponse = result.body()?.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text
                    _response.value = textResponse ?: "Aucune réponse reçue."

                    // Save the question and response to the database
                    saveHistory(userInput, textResponse ?: "Aucune réponse reçue.")
                } else {
                    _response.value = "Erreur : ${result.message()}"
                }
            } catch (e: Exception) {
                _response.value = "Exception : ${e.message}"
            }
        }
    }

    // Function to save the question and response to the local database
    private fun saveHistory(question: String, answer: String) {
        val timestamp = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(Date())
        val historyItem = HistoryItem(question = question, answer = answer, date = timestamp)

        // Save historyItem to the database
        viewModelScope.launch {
            //historyRepository.insertHistoryItem(historyItem)
        }
    }

//    fun getHistory(): Flow<List<HistoryItem>> {
//        return historyRepository.getAllHistoryItems()
//    }
}