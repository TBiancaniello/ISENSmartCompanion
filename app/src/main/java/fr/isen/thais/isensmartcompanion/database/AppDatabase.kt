package fr.isen.thais.isensmartcompanion.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.isen.thais.isensmartcompanion.dao.HistoryDao
import fr.isen.thais.isensmartcompanion.model.ChatEntry
import fr.isen.thais.isensmartcompanion.model.ConversationEntity
import fr.isen.thais.isensmartcompanion.model.HistoryItem

@Database(entities = [ConversationEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    //abstract fun conversationDao(): ConversationEntity

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "conversation_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
