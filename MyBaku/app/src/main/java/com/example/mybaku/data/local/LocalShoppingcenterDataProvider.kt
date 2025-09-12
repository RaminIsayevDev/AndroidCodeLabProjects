package com.example.mybaku.data.local

import com.example.mybaku.R
import com.example.mybaku.data.Skeleton

object LocalShoppingcenterDataProvider {
    val allShoppingCenters = listOf(
        Skeleton(
            id = 1L,
            image = R.drawable._8mall_image,
            name = R.string.mall28,
            description = R.string.mall28Description
        ),
        Skeleton(
            id = 2L,
            image = R.drawable.crescentmall_image,
            name = R.string.crescentMall,
            description = R.string.crescentMallDescription
        ),
        Skeleton(
            id = 3L,
            image = R.drawable.denizmall_image,
            name = R.string.denizMall,
            description = R.string.denizMallDescription
        ),
        Skeleton(
            id = 4L,
            image = R.drawable.ganjlikmall_image,
            name = R.string.ganjlikMall,
            description = R.string.ganjlikMallDescription
        ),
        Skeleton(
            id = 5L,
            image = R.drawable.portbakumall_image,
            name = R.string.portBakuMall,
            description = R.string.portBakuMallDescription
        )
    )

    fun get(id: Long): Skeleton {
        return allShoppingCenters.first { it.id == id }
    }
}