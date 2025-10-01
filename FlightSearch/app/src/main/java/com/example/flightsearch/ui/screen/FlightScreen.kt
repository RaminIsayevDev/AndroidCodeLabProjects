package com.example.flightsearch.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FlightScreen(
    modifier: Modifier = Modifier.fillMaxSize() // Added default modifier
) {
    val viewModel: FlightViewModel = viewModel(factory = FlightViewModel.Factory)
    // Use collectAsState for observing StateFlow/LiveData from ViewModel is generally preferred
    // However, viewModel.uiState directly exposes State<FlightSearchUiState>, so .value is correct here.
    val currentUiState by viewModel.uiState // Use property delegation for cleaner access

    Scaffold() { paddingValues ->

        Column(modifier = modifier
            .padding(paddingValues)
        ) {
            OutlinedTextField(
                value = currentUiState.searchText,
                onValueChange = viewModel::onSearchTextChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                label = { Text("Search") }
            )

            // Updated when condition to use currentUiState.isAirportSelectionMode
            if (currentUiState.isAirportSelectionMode && currentUiState.searchText.isNotBlank()) {
                SearchStateScreen(
                    searchResults = currentUiState.searchResults,
                    onAirportClick = viewModel::onAirportSelected // Pass the function reference
                )
            } else if (!currentUiState.isAirportSelectionMode) {
                // Placeholder for displaying flight routes from the selected airport
                // You'll likely want another Composable here, e.g., FlightRoutesScreen()
                Text("Displaying routes for ${currentUiState.searchText}")
            } else {
                // Placeholder for what to show when searchText is blank and not in route display mode
                // (e.g., favorite routes, or initial empty state)
                Text("Enter an airport to search or view favorites.")
            }
        }
    }
}
