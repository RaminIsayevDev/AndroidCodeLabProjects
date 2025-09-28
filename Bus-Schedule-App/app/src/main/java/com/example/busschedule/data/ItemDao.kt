package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: BusSchedule)

    @Update
    suspend fun update(item: BusSchedule)

    @Delete
    suspend fun delete(item: BusSchedule)

    @Query("SELECT * from schedule WHERE stop_name = :stopName")
    fun getItem(stopName: String): Flow<List<BusSchedule>>

    @Query("SELECT * from schedule ORDER BY arrival_time ASC")
    fun getAllItems(): Flow<List<BusSchedule>>
}