package com.example.mybaku.ui

import com.example.mybaku.data.Category
import com.example.mybaku.data.categories
import com.example.mybaku.data.Skeleton
import com.example.mybaku.data.local.LocalBakuDataProvider

data class UiState(
    val myCity: Skeleton = LocalBakuDataProvider.get(),
    val attractions: List<Skeleton> = emptyList(),
    val parks: List<Skeleton> = emptyList(),
    val shoppingCenters: List<Skeleton> = emptyList(),
    val currentSubCategory: Skeleton = Skeleton(
        id = 0L,
        name = 0,
        image = 0,
        description = 0
    )
)