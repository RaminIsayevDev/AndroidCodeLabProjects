package com.example.mybaku.data.local

import com.example.mybaku.R
import com.example.mybaku.data.Skeleton

object LocalBakuDataProvider {
    val cityBaku = Skeleton(
        id = 1L,
        image = R.drawable.baku_image,
        name = R.string.baku,
        description = R.string.bakuDescription
    )

    fun get(): Skeleton {
        return cityBaku
    }
}