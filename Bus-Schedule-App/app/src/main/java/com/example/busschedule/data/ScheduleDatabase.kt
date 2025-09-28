package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BusSchedule::class], version = 1, exportSchema = false)
abstract class ScheduleDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: ScheduleDatabase? = null

        fun getDatabase(context: Context): ScheduleDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ScheduleDatabase::class.java, "item_database")
                    .createFromAsset("database/bus_schedule.db") // This for creating the database from an asset file
                    .build()
                    .also { Instance = it }
            }
        }
    }
}