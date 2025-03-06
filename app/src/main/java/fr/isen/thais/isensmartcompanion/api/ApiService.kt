package fr.isen.thais.isensmartcompanion.api

import fr.isen.thais.isensmartcompanion.model.EventModel
import retrofit2.http.GET
import retrofit2.Call

interface ApiService {
    @GET("events.json")
    fun getEvents() : Call<List<EventModel>>
}