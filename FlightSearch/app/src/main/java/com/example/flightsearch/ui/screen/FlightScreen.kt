package com.example.flightsearch.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearch.data.models.Airport
import com.example.flightsearch.data.models.Route
import com.example.flightsearch.ui.theme.StarYellow

@Composable
fun FlightScreen(
    viewModel: FlightViewModel = viewModel(factory = FlightViewModel.Factory)
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = { FlightTopAppBar() }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            SearchBar(
                query = uiState.searchText,
                onQueryChange = viewModel::onSearchQueryChanged,
                onClear = viewModel::onClearSelection,
                modifier = Modifier.padding(16.dp)
            )

            // Determine which content to show based on the UI state
            if (uiState.searchText.isBlank()) {
                // Show favorite routes when search is empty
                RoutesList(
                    title = "Favorite Routes",
                    routes = uiState.routes,
                    viewModel = viewModel
                )
            } else if (uiState.selectedAirport == null) {
                // Show airport suggestions while typing and no airport is selected
                AirportSuggestionsList(
                    suggestions = uiState.airportSuggestions,
                    onAirportSelected = viewModel::onAirportSelected
                )
            } else {
                // Show routes from the selected airport
                RoutesList(
                    title = "Flights from ${uiState.selectedAirport?.code}",
                    routes = uiState.routes,
                    viewModel = viewModel
                )
            }
        }
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text("Search for an airport") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
        trailingIcon = {
            if (query.isNotBlank()) {
                IconButton(onClick = onClear) {
                    Icon(Icons.Default.Clear, contentDescription = "Clear Search")
                }
            }
        },
        shape = MaterialTheme.shapes.extraLarge,
        singleLine = true
    )
}

@Composable
fun AirportSuggestionsList(
    suggestions: List<Airport>,
    onAirportSelected: (Airport) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(suggestions) { airport ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onAirportSelected(airport) }
                    .padding(vertical = 8.dp)
            ) {
                Text(text = airport.code, fontWeight = FontWeight.Bold)
                Text(text = airport.name, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}

@Composable
fun RoutesList(title: String, routes: List<Route>, modifier: Modifier = Modifier, viewModel: FlightViewModel) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(routes) { route ->
                RouteCard(route = route, viewModel = viewModel)
            }
        }
    }
}

@Composable
fun RouteCard(route: Route, modifier: Modifier = Modifier, viewModel: FlightViewModel) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("DEPART", style = MaterialTheme.typography.labelSmall)
                Text(route.departAirport.name, fontWeight = FontWeight.Bold)
                Text("ARRIVE", style = MaterialTheme.typography.labelSmall, modifier = Modifier.padding(top = 8.dp))
                Text(route.arriveAirport.name, fontWeight = FontWeight.Bold)
            }
            IconButton(onClick = { viewModel.toggleFavorite(route) }) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "Is Favorite",
                    tint = if (route.isFavorite) StarYellow else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                "Flight Search",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        modifier = modifier
    )
}
