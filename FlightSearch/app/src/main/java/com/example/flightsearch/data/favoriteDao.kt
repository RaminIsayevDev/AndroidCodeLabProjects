package com.example.flightsearch.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.flightsearch.data.models.Favorite
import kotlinx.coroutines.flow.Flow

@Dao
interface favoriteDao {
    @Insert
    suspend fun insertFavorite(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)

    @Query("SELECT * FROM Favorite WHERE id = :id")
    fun getFavoriteById(id: Int): Flow<Favorite?>

    @Query("SELECT * FROM Favorite")
    fun getAllFavorites(): Flow<List<Favorite>>

    @Query("SELECT * FROM Favorite WHERE departure_code = :departureCode AND destination_code = :destinationCode")
    fun getFavoriteByCodes(departureCode: String, destinationCode: String): Flow<Favorite?>

    @Query("DELETE FROM Favorite WHERE departure_code = :departureCode AND destination_code = :destinationCode")
    suspend fun deleteByCodes(departureCode: String, destinationCode: String)

}