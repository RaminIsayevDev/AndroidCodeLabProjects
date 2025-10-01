package com.example.flightsearch.ui.screen

import androidx.activity.result.launch
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearch.FlightApplication
import com.example.flightsearch.data.FlightRepository
import com.example.flightsearch.data.models.Airport
import com.example.flightsearch.data.models.Route
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FlightViewModel(private val flightRepository: FlightRepository) : ViewModel() {

    private val _internalUiState = mutableStateOf(FlightSearchUiState()) // Holds the mutable state
    val uiState: State<FlightSearchUiState> = _internalUiState       // Exposes an immutable State

    // Example of how you might update it
    fun onSearchTextChanged(newText: String) {
        _internalUiState.value = _internalUiState.value.copy(searchText = newText, isAirportSelectionMode = true)
        // Call searchAirport whenever searchText changes
        if (newText.isNotBlank()) {
            searchAirport(newText)
        } else {
            // Clear results if search text is blank
            _internalUiState.value = _internalUiState.value.copy(searchResults = emptyList())
        }
    }

    fun searchAirport(query: String) {
        viewModelScope.launch {
            // Assuming flightRepository has a method like getAirportsByQueryStream(query)
            // that returns a Flow<List<Airport>>. Adjust if your method is different.
            flightRepository.searchAirport(query) // Or your equivalent suspend function
                .collectLatest { airports ->
                    _internalUiState.value = _internalUiState.value.copy(searchResults = airports)
                }
        }
    }

    fun onAirportSelected(airport: Airport) {
        _internalUiState.value = _internalUiState.value.copy(
            searchText = airport.code, // Or airport.name, depending on what you want to show
            searchResults = emptyList(),   // Clear search results
            isAirportSelectionMode = false // Move to the next state (e.g., showing routes)
        )
        // Here you would typically trigger loading of flight routes from this airport
        // For example: loadFlightRoutes(airport.iataCode)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FlightApplication)
                FlightViewModel(application.offlineFlightRepository)
            }
        }
    }
}

data class FlightSearchUiState(
    // Текущий текст в поле поиска
    val searchText: String = "",

    // Список результатов, который отображается (зависит от searchText)
    val searchResults: List<Airport> = emptyList(),

    // Список избранных маршрутов (отображается, когда searchText пуст)
    val favoriteRoutes: List<Route> = emptyList(),

    // Флаг для определения, находится ли пользователь в режиме выбора аэропорта
    val isAirportSelectionMode: Boolean = true // Например, выбор аэропорта отправления
) {
    // Вычисляемое свойство для удобства:
    // This logic might need adjustment based on when you want to show suggestions.
    // For instance, even if searchText is populated by selection, you might not want to be "searching".
    val isSearching: Boolean
        get() = searchText.isNotBlank() && searchResults.isNotEmpty() && isAirportSelectionMode
}
