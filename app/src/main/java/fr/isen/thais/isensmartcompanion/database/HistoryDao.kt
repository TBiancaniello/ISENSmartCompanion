package fr.isen.thais.isensmartcompanion.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import fr.isen.thais.isensmartcompanion.model.HistoryItem
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

//    @Insert
//    suspend fun insertHistoryItem(historyItem: HistoryItem)
//
//    @Query("SELECT * FROM history ORDER BY date DESC")
//    fun getAllHistoryItems(): Flow<List<HistoryItem>>
//
//    @Delete
//    suspend fun deleteHistoryItemById(historyItem: HistoryItem)
//
//    @Query("DELETE FROM history")
//    suspend fun deleteAllHistoryItems()


}
