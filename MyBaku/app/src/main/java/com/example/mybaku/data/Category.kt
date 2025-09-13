package com.example.mybaku.data

import androidx.annotation.DrawableRes
import com.example.mybaku.R

val categories = listOf(
    Category(R.drawable.shoppingcentericon, "Shopping Centers"),
    Category(R.drawable.park_icon, "Parks"),
    Category(R.drawable.kuala_icon, "Attractions")
)

data class Category(
    @DrawableRes val icon: Int,
    val name: String
)
