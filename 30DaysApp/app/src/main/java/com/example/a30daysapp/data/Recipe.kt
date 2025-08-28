package com.example.a30daysapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30daysapp.R

data class Recipe(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    val ingredients: Map<String, String>,
    val instructions: List<String>,
)

val recipes = listOf(

    Recipe(
        name = R.string.recipe_name_1,
        image = ,
        ingredients = mapOf(
            "Rolled oats" to "1/2 cup",
            "Water or milk" to "1 cup",
            "Pich of salt" to "1 tsp",
            "Banana" to "1/2 sliced",
            "Berries" to "1/4 cup",
            "Nuts or seeds" to "1tbsp",
            "Honey or maple syrup" to "optional"
        ),
        instructions = listOf(
            "Boil oats with water/milk and salt for 5–10 min until thick.",
            "Remove from heat, let cool slightly.",
            "Top with fruits, nuts, and sweetener.",
            "Serve warm."
        )
    ),


)