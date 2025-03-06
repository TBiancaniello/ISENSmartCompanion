package fr.isen.thais.isensmartcompanion.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.isen.thais.isensmartcompanion.gemini.GeminiViewModel

@Composable
fun GeminiScreen(viewModel: GeminiViewModel = viewModel()) {
    var userInput by remember { mutableStateOf("") }
    val response by viewModel.response.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Type your request") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { viewModel.sendRequest(userInput) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send to Gemini")
        }

        Spacer(modifier = Modifier.height(16.dp))

        response?.let {
            Text("Gemini's response :", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
            Text(it)
        }
    }
}
