package com.example.flightsearch.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearch.FlightApplication
import com.example.flightsearch.data.FlightRepository
import com.example.flightsearch.data.models.Airport
import com.example.flightsearch.data.models.Favorite
import com.example.flightsearch.data.models.Route
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// A much simpler and more robust UI state
data class FlightUiState(
    val searchText: String = "",
    // Suggestions for airports based on the search text
    val airportSuggestions: List<Airport> = emptyList(),
    // Routes to display. Either favorites (if searchText is empty) or from a selected airport.
    val routes: List<Route> = emptyList(),
    // The currently selected departure airport
    val selectedAirport: Airport? = null
)

class FlightViewModel(private val flightRepository: FlightRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(FlightUiState())
    val uiState: StateFlow<FlightUiState> = _uiState.asStateFlow()

    private var searchJob: Job? = null
    private var routeJob: Job? = null

    init {
        // Initially, load the favorite routes when the view model is created
        loadFavoriteRoutes()
    }

    /**
     * Handles changes to the search text field.
     */
    fun onSearchQueryChanged(query: String) {
        _uiState.update { it.copy(searchText = query) }

        if (query.isBlank()) {
            // When the query is cleared, go back to showing favorite routes
            onClearSelection()
        } else {
            // As the user types, show airport suggestions
            searchJob?.cancel() // Cancel any previous search
            routeJob?.cancel()  // Cancel any route loading
            _uiState.update { it.copy(routes = emptyList(), selectedAirport = null) } // Clear routes and selection
            searchJob = viewModelScope.launch {
                flightRepository.searchAirport(query).collectLatest { airports ->
                    _uiState.update { it.copy(airportSuggestions = airports) }
                }
            }
        }
    }

    /**
     * Handles when a user selects an airport from the suggestions.
     */
    fun onAirportSelected(airport: Airport) {
        searchJob?.cancel() // Stop searching for suggestions
        _uiState.update {
            it.copy(
                searchText = airport.code,
                selectedAirport = airport,
                airportSuggestions = emptyList() // Clear suggestions
            )
        }
        // Load the routes for the selected airport
        loadRoutesForAirport(airport.code)
    }

    /**
     * Clears the selection and search, returning the UI to the initial state (showing favorites).
     */
    fun onClearSelection() {
        searchJob?.cancel()
        _uiState.update {
            it.copy(
                searchText = "",
                selectedAirport = null,
                airportSuggestions = emptyList()
            )
        }
        loadFavoriteRoutes()
    }

    fun toggleFavorite(route: Route) {
        viewModelScope.launch {
            val favorite = Favorite(
                departureCode = route.departAirport.code,
                destinationCode = route.arriveAirport.code
            )
            if (route.isFavorite) {
                flightRepository.deleteByCodes(route.departAirport.code, route.arriveAirport.code)
            } else {
                flightRepository.insertFavorite(favorite)
            }
        }
    }

    /**
     * Loads all routes departing from a specific airport code.
     */
    private fun loadRoutesForAirport(code: String) {
        routeJob?.cancel()
        routeJob = viewModelScope.launch {
            flightRepository.getRoutesForAirport(code).collectLatest { routes ->
                _uiState.update { it.copy(routes = routes) }
            }
        }
    }

    /**
     * Loads the user's favorite routes. This is shown when the search bar is empty.
     */
    private fun loadFavoriteRoutes() {
        routeJob?.cancel()
        routeJob = viewModelScope.launch {
            // We need to get the full airport details for the codes stored in favorites.
            // Combining flows is an efficient way to do this.
            flightRepository.getAllFavorites().combine(flightRepository.getAllAirports()) { favorites, airports ->
                favorites.mapNotNull { fav ->
                    val departureAirport = airports.find { it.code == fav.departureCode }
                    val destinationAirport = airports.find { it.code == fav.destinationCode }
                    if (departureAirport != null && destinationAirport != null) {
                        Route(departureAirport, destinationAirport, isFavorite = true)
                    } else {
                        null // Should not happen if data is consistent
                    }
                }
            }.collectLatest { favoriteRoutes ->
                _uiState.update { it.copy(routes = favoriteRoutes) }
            }
        }
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
