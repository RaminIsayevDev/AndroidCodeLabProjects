package com.example.flightsearch.data.models

data class Route(
    val departAirport: Airport,
    val arriveAirport: Airport,
    val isFavorite: Boolean = false
)