package com.example.flightsearch.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.flightsearch.data.models.Airport
import kotlinx.coroutines.flow.Flow

@Dao
interface airportDao {
    @Update
    suspend fun updateAirport(airport: Airport)

    @Delete
    suspend fun deleteAirport(airport: Airport)

    @Insert
    suspend fun insertAirport(airport: Airport)

    @Query("SELECT * FROM Airport WHERE id = :id")
    fun getAirportById(id: Int): Flow<Airport?>

    @Query("SELECT * FROM Airport WHERE name LIKE '%' || :query || '%'")
    fun searchAirports(query: String): Flow<List<Airport>>

    @Query("SELECT * FROM Airport WHERE iata_code = :code")
    fun getAirportByCode(code: String): Flow<Airport?>

    @Query("SELECT * FROM Airport")
    fun getAllAirports(): Flow<List<Airport>>
}