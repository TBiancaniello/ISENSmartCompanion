package fr.isen.thais.isensmartcompanion.model

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.io.Serializable


//with class constructor because it hasn't been initialized before
class EventModel (
    val id: String,
    val title: String,
    val description: String,
    val date: String,
    val location: String,
    val category: String):Serializable{

    companion object{
        fun fakeEvents(): List<EventModel> {
            return listOf(
                EventModel("1", "BDE Evening", "A night of fun organized by BDE!", "March 5, 2025", "ISEN Campus", "Party"),
                EventModel("2", "Gala", "The annual ISEN Gala night!", "April 20, 2025", "Grand Hotel", "Formal"),
                EventModel("3", "Cohesion Day", "A day for students to bond and enjoy activities.", "May 15, 2025", "City Park", "Social"),
                EventModel("4", "Tech Conference", "Latest trends in AI and tech!", "June 10, 2025", "ISEN Auditorium", "Educational"),
                EventModel("5", "Gaming Tournament", "Compete with fellow students in e-sports!", "July 2, 2025", "Student Lounge", "Competition")
            )
        }

        @Composable
        fun EventRow(event: EventModel) {
            val context = LocalContext.current
            //event.handler better than LocalContext
            Card(
                modifier=Modifier
                    .padding(16.dp)
                    .clickable {
                        Log.d("event", "event")

                    }
            ){
                Column(
                    modifier=Modifier.padding(16.dp)) {
                    Text(event.title)
                    Text(event.description)
                }
            }
        }
    }





}