package com.example.flightsearch

import android.app.Application
import com.example.flightsearch.data.FlightDatabase
import com.example.flightsearch.data.OfflineFlightRepository

class FlightApplication : Application() {

    private val database: FlightDatabase by lazy { FlightDatabase.getDatabase(this) }

    val airportDaoInstance by lazy { database.airportDao() }
    val favoriteDaoInstance by lazy { database.favoriteDao() }

    lateinit var offlineFlightRepository: OfflineFlightRepository

    override fun onCreate() {
        super.onCreate()
        offlineFlightRepository = OfflineFlightRepository(airportDao = airportDaoInstance, favoriteDao = favoriteDaoInstance)
    }
}