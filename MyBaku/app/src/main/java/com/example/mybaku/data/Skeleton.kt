package com.example.mybaku.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Skeleton(
    val id: Long,
    @DrawableRes val image: Int,
    @StringRes val name: Int,
    @StringRes val description: Int
)
