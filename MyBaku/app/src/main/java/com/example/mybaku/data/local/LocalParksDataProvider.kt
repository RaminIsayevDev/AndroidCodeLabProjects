package com.example.mybaku.data.local

import com.example.mybaku.R
import com.example.mybaku.data.Skeleton

object LocalParksDataProvider {
    val allParks = listOf(
        Skeleton(
            id = 1L,
            image = R.drawable.botanicalgarden_image,
            name = R.string.botanicalGarden,
            description = R.string.botanicalGardenDescription
        ),
        Skeleton(
            id = 2L,
            image = R.drawable.dadagorgudpark_image,
            name = R.string.dadagorgudPark,
            description = R.string.dadagorgudParkDescription
        ),
        Skeleton(
            id = 3L,
            image = R.drawable.nizamipark_image,
            name = R.string.nizamiPark,
            description =R.string.nizamiParkDescription
        ),
        Skeleton(
            id = 4L,
            image = R.drawable.merkezipark_image,
            name = R.string.merkeziPark,
            description = R.string.merkeziParkDescription
        )
    )

    fun get(id: Long): Skeleton {
        return allParks.first { it.id == id }
    }
}