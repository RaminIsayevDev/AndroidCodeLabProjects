package com.example.flightsearch.data

import com.example.flightsearch.data.models.Airport
import com.example.flightsearch.data.models.Favorite
import com.example.flightsearch.data.models.Route
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class OfflineFlightRepository(private val airportDao: airportDao, private val favoriteDao: favoriteDao) : FlightRepository {
    // For airportDao
    override fun getAllAirports(): Flow<List<Airport>> = airportDao.getAllAirports()
    override fun getAirportByCode(code: String): Flow<Airport?> = airportDao.getAirportByCode(code = code)
    override fun getAirportById(id: Int): Flow<Airport?> = airportDao.getAirportById(id = id)
    override fun searchAirport(query: String): Flow<List<Airport>> = airportDao.searchAirports(query = query)
    override suspend fun insertAirport(airport: Airport) = airportDao.insertAirport(airport = airport)
    override suspend fun updateAirport(airport: Airport) = airportDao.updateAirport(airport = airport)
    override suspend fun deleteAirport(airport: Airport) = airportDao.deleteAirport(airport = airport)

    // For favoriteDao
    override fun getAllFavorites(): Flow<List<Favorite>> = favoriteDao.getAllFavorites()
    override fun getFavoriteById(id: Int): Flow<Favorite?> = favoriteDao.getFavoriteById(id = id)
    override fun getFavoriteByCodes(departureCode: String, destinationCode: String): Flow<Favorite?> = favoriteDao.getFavoriteByCodes(departureCode = departureCode, destinationCode = destinationCode)
    override suspend fun insertFavorite(favorite: Favorite) = favoriteDao.insertFavorite(favorite = favorite)
    override suspend fun deleteFavorite(favorite: Favorite) = favoriteDao.deleteFavorite(favorite = favorite)
    override suspend fun deleteByCodes(departureCode: String, destinationCode: String) = favoriteDao.deleteByCodes(departureCode, destinationCode)

    // Route
    override fun getAllRoutes(): Flow<List<Route>> {
        return airportDao.getAllAirports().combine(favoriteDao.getAllFavorites()) { airports, favorites ->
            airports.flatMap { departureAirport ->
                airports.mapNotNull { arrivalAirport ->
                    if (departureAirport != arrivalAirport) {
                        val isFavorite = favorites.any {
                            it.departureCode == departureAirport.code && it.destinationCode == arrivalAirport.code
                        }
                        Route(
                            departAirport = departureAirport,
                            arriveAirport = arrivalAirport,
                            isFavorite = isFavorite
                        )
                    } else {
                        null
                    }
                }
            }
        }
    }

    override fun getRoutesForAirport(code: String): Flow<List<Route>> {
        return airportDao.getAllAirports().combine(favoriteDao.getAllFavorites()) { airports, favorites ->
            val departureAirport = airports.find { it.code == code }

            if (departureAirport != null) {
                airports.mapNotNull { arrivalAirport ->
                    if (departureAirport.code != arrivalAirport.code) {
                        val isFavorite = favorites.any {
                            it.departureCode == departureAirport.code && it.destinationCode == arrivalAirport.code
                        }
                        Route(
                            departAirport = departureAirport,
                            arriveAirport = arrivalAirport,
                            isFavorite = isFavorite
                        )
                    } else {
                        null
                    }
                }
            } else {
                emptyList()
            }
        }
    }
}