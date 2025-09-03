package com.example.dessertclicker.ui

import com.example.dessertclicker.data.Datasource

data class GameUiState (
    var revenue: Int = 0,
    var dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    var currentDessertPrice: Int = Datasource.dessertList[currentDessertIndex].price,
    var currentDessertImageId: Int = Datasource.dessertList[currentDessertIndex].imageId
    )