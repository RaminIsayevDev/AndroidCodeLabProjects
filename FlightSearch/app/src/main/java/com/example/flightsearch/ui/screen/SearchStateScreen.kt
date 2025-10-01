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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.flightsearch.data.models.Airport

@Composable
fun SearchStateScreen(
    searchResults: List<Airport>,
    onAirportClick: (Airport) -> Unit = {},
) {
    LazyColumn(
        contentPadding = PaddingValues(all = 8.dp), // Added some padding around the LazyColumn
        verticalArrangement = Arrangement.spacedBy(8.dp) // Added spacing between items
    ) {
        items(searchResults, key = { airport -> airport.id }) { airport ->
            AirportRow(
                airport = airport,
                onAirportClick = { onAirportClick(airport) }
            )
        }
    }
}

@Composable
fun AirportRow(
    airport: Airport,
    onAirportClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onAirportClick() }
            .padding(vertical = 8.dp, horizontal = 16.dp) // Adjusted padding for better visuals
    ) {
        Text(
            text = airport.code,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = airport.name)
    }
}
