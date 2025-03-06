package fr.isen.thais.isensmartcompanion.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "chat_entries")
data class ChatEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val question: String,
    val answer: String,
    val timestamp: Long = System.currentTimeMillis()
)
