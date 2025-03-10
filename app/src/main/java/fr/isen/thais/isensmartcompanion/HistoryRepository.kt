package fr.isen.thais.isensmartcompanion.repository

import fr.isen.thais.isensmartcompanion.dao.HistoryDao
import fr.isen.thais.isensmartcompanion.model.HistoryItem
import kotlinx.coroutines.flow.Flow

class HistoryRepository(private val historyDao: HistoryDao) {

    suspend fun insertHistoryItem(historyItem: HistoryItem) {
        //historyDao.insertHistoryItem(historyItem)
    }

//    fun getAllHistoryItems(): Flow<List<HistoryItem>> {
//        return historyDao.getAllHistoryItems()
//    }

    suspend fun deleteHistoryItemById(id: Int) {
//        val item = HistoryItem(id = id, question = "", answer = "", date = "") // Créer un HistoryItem fictif pour suppression
//        historyDao.deleteHistoryItemById(item)
    }

    suspend fun deleteAllHistoryItems() {
//        historyDao.deleteAllHistoryItems()
    }
}
