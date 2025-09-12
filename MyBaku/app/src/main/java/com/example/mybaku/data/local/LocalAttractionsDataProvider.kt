package com.example.mybaku.data.local

import com.example.mybaku.R
import com.example.mybaku.data.Skeleton

object LocalAttractionsDataProvider {
    val allAttractions = listOf(
        Skeleton(
            id = 1L,
            image = R.drawable.qala_image,
            name = R.string.qala,
            description = R.string.qalaDescription
        ),
        Skeleton(
            id = 2L,
            image = R.drawable.bayragmeydani_image,
            name = R.string.bayragMeydani,
            description = R.string.bayragMeydaniDescription
        ),
        Skeleton(
            id = 3L,
            image = R.drawable.shirvanshahlarsaray_image,
            name = R.string.shirvanshaxlarSarayi,
            description = R.string.shirvanshaxlarSarayiDescription
        ),
        Skeleton(
            id = 4L,
            image = R.drawable.qizqalasi_image,
            name = R.string.qizQalasi,
            description = R.string.qizQalasiDescription
        )
    )

    fun get(id: Long): Skeleton {
        return allAttractions.first { it.id == id }
    }
}