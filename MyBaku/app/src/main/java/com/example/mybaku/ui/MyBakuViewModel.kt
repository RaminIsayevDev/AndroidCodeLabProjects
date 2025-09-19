package com.example.mybaku.ui

import androidx.lifecycle.ViewModel
import com.example.mybaku.data.Skeleton
import com.example.mybaku.data.local.LocalAttractionsDataProvider
import com.example.mybaku.data.local.LocalBakuDataProvider
import com.example.mybaku.data.local.LocalParksDataProvider
import com.example.mybaku.data.local.LocalShoppingcenterDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.mybaku.ui.UiState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyBakuViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val attractions: List<Skeleton> = LocalAttractionsDataProvider.allAttractions
        val parks: List<Skeleton> = LocalParksDataProvider.allParks
        val shoppingCenters: List<Skeleton> = LocalShoppingcenterDataProvider.allShoppingCenters
        _uiState.value =
            UiState(
                attractions = attractions,
                parks = parks,
                shoppingCenters = shoppingCenters
            )
    }

    // Here we'll add more functions to update the state
    fun subCategoryUpdate(skeleton: Skeleton) {
        _uiState.update { currentState -> currentState.copy(currentSubCategory = skeleton) }
    }

}
