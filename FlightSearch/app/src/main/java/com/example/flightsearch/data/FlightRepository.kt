package com.example.flightsearch.data

import com.example.flightsearch.data.models.Airport
import com.example.flightsearch.data.models.Favorite
import kotlinx.coroutines.flow.Flow

interface FlightRepository {
    // For airportDao

    fun getAllAirports(): Flow<List<Airport>>

    fun getAirportByCode(code: String): Flow<Airport?>
    fun getAirportById(id: Int): Flow<Airport?>
    fun searchAirport(query: String): Flow<List<Airport>>

    suspend fun insertAirport(airport: Airport)
    suspend fun updateAirport(airport: Airport)
    suspend fun deleteAirport(airport: Airport)

    // For favoriteDao

    fun getAllFavorites(): Flow<List<Favorite>>

    fun getFavoriteById(id: Int): Flow<Favorite?>
    fun getFavoriteByCodes(departureCode: String, destinationCode: String): Flow<Favorite?>

    suspend fun insertFavorite(favorite: Favorite)
    suspend fun deleteFavorite(favorite: Favorite)
}
