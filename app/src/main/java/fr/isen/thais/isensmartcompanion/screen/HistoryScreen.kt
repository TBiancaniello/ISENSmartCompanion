package fr.isen.thais.isensmartcompanion.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.isen.thais.isensmartcompanion.model.HistoryItem
import fr.isen.thais.isensmartcompanion.gemini.viewmodel.GeminiViewModel
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch



@Composable
fun HistoryScreen(geminiViewModel: GeminiViewModel) {
    // Créer un état mutable pour stocker les éléments de l'historique
    val historyItems = remember { mutableStateOf<List<HistoryItem>>(emptyList()) }

    // Collecte les données du Flow dans une coroutine
    LaunchedEffect(Unit) {
        geminiViewModel.viewModelScope.launch {
//            geminiViewModel.getHistory().collect { history ->
//                historyItems.value = history
//            }
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        // Afficher chaque élément de l'historique
        historyItems.value.forEach { historyItem ->
            Text(text = "Question: ${historyItem.question}")
            Text(text = "Answer: ${historyItem.answer}")
            Text(text = "Date: ${historyItem.date}")
        }
    }
}

@Composable
fun HistoryItemView(historyItem: HistoryItem) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Question: ${historyItem.question}")
        Text(text = "Answer: ${historyItem.answer}")
        Text(text = "Date: ${historyItem.date}")
    }
}
