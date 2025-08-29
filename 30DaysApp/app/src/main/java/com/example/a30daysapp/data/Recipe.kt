package com.example.a30daysapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
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
        image = R.drawable.image_1,
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

    Recipe(
        name = R.string.recipe_name_2,
        image = R.drawable.image_2,
        ingredients = mapOf(
            "Olive oil or butter" to "1 tbsp",
            "Small onion, finely chopped" to "1",
            "Carrot, diced" to "1",
            "Potato, peeled and cubed" to "1",
            "Vegetable broth" to "2 cups",
            "Cream or plain yogurt" to "1/2 cup",
            "Salt and pepper" to "to taste",
            "Fresh parsley or dill for garnish" to "1"
        ),
        instructions = listOf(
            "Saute onion in oil until translucent.",
            "Add carrot and potato, cook for 5 minutes",
            "Pour in broth, simmer, until vegetable are soft(15-20 min).",
            "Blend until smooth (optional for creamy texture).",
            "Stir in cream or yogurt, season with salt and pepper",
            "Garnish with fresh herbs and serve warm."
        )
    ),

    Recipe(
        name = R.string.recipe_name_3,
        image = R.drawable.image_3,
        ingredients = mapOf(
            "Cherry tomatoes, halved" to "1/2 cup",
            "Cucumber, diced" to "diced",
            "Red onion, thinly sliced" to "1/4 cup",
            "Orange bell peper, chopped" to "1/4 cup",
            "Black olives (Kalamata preferred)" to "1/4 cup",
            "Feta cheese, cubed or crumbled" to "1/2 cup",
            "Fresh oregano or dried oregano" to "1 tbsp",
            "Salt and black pepper" to "to taste"
        ),
        instructions = listOf(
            "Combine all salad ingredients in a large bowl.",
            "Whisk dressing ingredients until emulsified.",
            "Pour dressing over salad, toss gently.",
            "Garnish with extra oregano or herbs.",
            "Serve chilled or at room temperature."
        )
    ),

    Recipe(
        name = R.string.recipe_name_4,
        image = R.drawable.image_4,
        ingredients = mapOf(
            "Olive oil" to "1 tbsp",
            "Onion, finely chopped" to "1",
            "Garlic cloves, minced" to "2",
            "Ground beef" to "500g",
            "Canned crushed tomatoes" to "400g",
            "Tomato paste" to "2 tbsp",
            "Dried oregano" to "1 tsp",
            "Salt and black pepper" to "to taste"
        ),
        instructions = listOf(
            "Sauté onion and garlic in oil. Add ground meat, cook until browned. Stir in tomatoes, paste, oregano, salt, and pepper. Simmer 15–20 min.",
            "Melt butter, whisk in flour. Slowly add milk, stirring until thick. Season with salt and nutmeg.",
            "In a baking dish, layer meat sauce, lasagna sheets, béchamel (if using), and cheese. Repeat layers, finishing with cheese on top.",
            "Cover with foil and bake at 180°C (350°F) for 30 min. Uncover and bake another 10–15 min until golden and bubbling.",
            "Let sit 10 min before slicing. Garnish with herbs."
        )
    ),

    Recipe(
        name = R.string.recipe_name_5,
        image = R.drawable.image_5,
        ingredients = mapOf(
            "Beef chuck or stew meat" to "500g",
            "Olive or sunflower oil" to "1 tbsp",
            "Onion" to "1, chopped",
            "Garlic cloves" to "2, minced",
            "Carrots" to "2, sliced",
            "Potatoes" to "2, cubed",
            "Tomato paste (optional)" to "1 tbsp",
            "Bay leaf" to "1",
            "Rosemary (fresh sprig or ½ tsp dried)" to "1",
            "Salt and black pepper" to "to taste",
            "Beef broth or water" to "4 cups"
        ),
        instructions = listOf(
            "Brown the beef in oil until seared.",
            "Sauté onion and garlic until soft.",
            "Add tomato paste, beef, vegetables, herbs, and broth.",
            "Simmer covered for 1.5–2 hours until tender.",
            "Adjust seasoning and serve hot with garnish."
        )
    ),

    Recipe(
        name = R.string.recipe_name_6,
        image = R.drawable.image_6,
        ingredients = mapOf(
            "Fish fillets (cod, haddock, etc.)" to "2",
            "Carrots" to "3, cut into sticks",
            "Parsnips or potatoes" to "2, cut into sticks",
            "Onion" to "1, sliced",
            "Olive oil" to "3 tbsp",
            "Dried herbs (thyme, rosemary, dill, etc.)" to "1 tsp",
            "Lemon zest" to "1 tsp",
            "Salt and pepper" to "to taste",
            "Lemon wedges" to "for serving",
            "Fresh dill" to " (optional)"
        ),
        instructions = listOf(
            "Preheat oven to 200°C (390°F).",
            "Toss vegetables with oil, herbs, salt, and pepper. Spread on baking tray.",
            "Roast vegetables for 20 minutes.",
            "Add fish fillets on top, sprinkle with lemon zest and dill.",
            "Bake another 15–20 minutes until fish is flaky.",
            "Serve with lemon wedges and garnish."
        )
    ),

    Recipe(
        name = R.string.recipe_name_7,
        image = R.drawable.image_7,
        ingredients = mapOf(
            "Graham crackers" to "150g",
            "Melted butter" to "80g",
            "Cream cheese" to "500g",
            "Sugar" to "150g",
            "Eggs" to "3",
            "Sour cream" to "200g",
            "Vanilla extract" to "1 tsp",
            "Cherries" to "300g, pitted",
            "Sugar (for sauce)" to "50g",
            "Lemon juice" to "1 tbsp"
        ),
        instructions = listOf(
            "Crush graham crackers and mix with melted butter. Press into pan.",
            "Blend cream cheese, sugar, eggs, sour cream, and vanilla until smooth.",
            "Pour over crust and bake at 160°C (320°F) for 50–60 minutes. Cool completely.",
            "Simmer cherries with sugar and lemon juice until thick and glossy.",
            "Top cheesecake with cherry sauce and chill before serving."
        )
    ),

    Recipe(
        name = R.string.recipe_name_8,
        image = R.drawable.image_8,
        ingredients = mapOf(
            "Mushrooms (button or cremini)" to "300g, sliced",
            "Onion" to "1, finely chopped",
            "Garlic cloves" to "2, minced",
            "Butter" to "2 tbsp",
            "Flour" to "2 tbsp",
            "Vegetable or chicken broth" to "3 cups",
            "Heavy cream or milk" to "1 cup",
            "Salt and black pepper" to "to taste",
            "Fresh thyme or parsley" to "1 tsp",
            "Roasted nuts (optional garnish)" to "",
            "Chili oil or olive oil drizzle" to ""
        ),
        instructions = listOf(
            "Sauté onion and garlic in butter until soft.",
            "Add mushrooms and cook until browned and reduced.",
            "Sprinkle flour, stir well to coat and thicken.",
            "Pour in broth, simmer for 15 minutes.",
            "Blend partially or fully for creamy texture.",
            "Stir in cream, season with salt, pepper, and herbs.",
            "Garnish with nuts, oil drizzle, and fresh herbs."
        )
    ),

    Recipe(
        name = R.string.recipe_name_9,
        image = R.drawable.image_9,
        ingredients = mapOf(
            "Lamb stewing meat" to "700g",
            "Potatoes" to "4, cubed",
            "Carrots" to "3, sliced",
            "Onion" to "1, chopped",
            "Garlic cloves" to "2, minced",
            "Olive oil" to "2 tbsp",
            "Beef or vegetable broth" to "3 cups",
            "Dried rosemary and/or thyme" to "1 tsp",
            "Salt and black pepper" to "to taste",
            "Fresh parsley" to "(optional garnish)"
        ),
        instructions = listOf(
            "Brown the lamb in oil, then set aside.",
            "Sauté onion, carrots, and garlic.",
            "Add broth, lamb, potatoes, rosemary, thyme, salt, and pepper.",
            "Simmer covered for 1.5–2 hours until tender.",
            "Adjust seasoning and serve garnished with parsley."
        )
    ),

    Recipe(
        name = R.string.recipe_name_10,
        image = R.drawable.image_10,
        ingredients = mapOf(
            "Flour" to "200g",
            "Sugar" to "2 tbsp",
            "Baking powder" to "2 tsp",
            "Salt" to "1/4 tsp",
            "Milk" to "250ml",
            "Egg" to "1",
            "Melted butter" to "40g",
            "Vanilla extract" to "1 tsp",
            "Fresh berries (e.g., raspberries)" to "150g",
            "Powdered sugar (for dusting)" to "",
            "Fresh mint (optional garnish)" to ""
        ),
        instructions = listOf(
            "Mix dry ingredients.",
            "Add wet ingredients, stir until combined.",
            "Pour batter into pan and cook until golden.",
            "Stack pancakes and top with berries.",
            "Dust with sugar, garnish with mint."
        )
    ),

    Recipe(
        name = R.string.recipe_name_11,
        image = R.drawable.image_11,
        ingredients = mapOf(
            "Eggs" to "4",
            "Fresh herbs (e.g., parsley, chives)" to "2 tbsp, chopped",
            "Salt" to "1/4 tsp",
            "Black pepper" to "a pinch",
            "Olive oil or butter" to "1 tbsp",
            "Optional fillings (e.g., cheese, vegetables)" to ""
        ),
        instructions = listOf(
            "Beat eggs with herbs, salt, and pepper.",
            "Heat oil in a pan, pour in eggs.",
            "Cook gently, add fillings if desired.",
            "Fold and cook until set and golden."
        )
    ),

    Recipe(
        name = R.string.recipe_name_12,
        image = R.drawable.image_12,
        ingredients = mapOf(
            "Beef or pork" to "300g",
            "Beetroot" to "2, grated",
            "Potatoes" to "3, diced",
            "Carrot" to "1, chopped",
            "Onion" to "1, chopped",
            "Garlic cloves" to "3, minced",
            "Cabbage" to "2 cups, shredded",
            "Tomato paste" to "2 tbsp",
            "Beef or vegetable broth" to "6 cups",
            "Salt and pepper" to "to taste",
            "Sour cream" to "(for serving)",
            "Fresh parsley or dill" to "(optional garnish)"
        ),
        instructions = listOf(
            "Brown meat, set aside.",
            "Cook onion, carrot, and garlic.",
            "Add broth, meat, beets, potatoes, tomato paste, salt, and pepper.",
            "Simmer, add cabbage, and cook for 20 minutes.",
            "Serve with sour cream and parsley."
        )
    ),

    Recipe(
        name = R.string.recipe_name_13,
        image = R.drawable.image_13,
        ingredients = mapOf(
            "Ribeye steak" to "1 (about 350g)",
            "Olive oil" to "1 tbsp",
            "Salt" to "to taste",
            "Black pepper" to "to taste",
            "Fresh herbs (e.g., rosemary, thyme, optional)" to "",
            "Fresh arugula (optional)" to ""
        ),
        instructions = listOf(
            "Pat steak dry and brush with oil.",
            "Season steak with salt and pepper.",
            "Grill on high heat to desired doneness.",
            "Rest, slice, and serve over arugula."
        )
    ),

    Recipe(
        name = R.string.recipe_name_14,
        image = R.drawable.image_14,
        ingredients = mapOf(
            "Pizza dough" to "1",
            "Tomato sauce" to "1/2 cup",
            "Fresh mozzarella" to "200g, sliced",
            "Cherry tomatoes" to "150g, sliced",
            "Fresh basil leaves" to "",
            "Olive oil" to "1 tbsp"
        ),
        instructions = listOf(
            "Roll out dough and spread with sauce.",
            "Top with mozzarella, tomatoes, and basil.",
            "Drizzle with olive oil.",
            "Bake at 475°F for 10–12 minutes."
        )
    ),

    Recipe(
        name = R.string.recipe_name_15,
        image = R.drawable.image_15,
        ingredients = mapOf(
            "Pork or chicken" to "300g, sliced",
            "Garlic cloves" to "3, minced",
            "Chili powder" to "to taste",
            "Ground cumin" to "to taste",
            "Corn tortillas" to "4",
            "Fresh cilantro" to "",
            "Chopped onion" to "",
            "Lime wedges" to ""
        ),
        instructions = listOf(
            "Sauté garlic and add meat and spices.",
            "Cook until meat is done.",
            "Fill tortillas with meat, cilantro, and onion.",
            "Serve with lime wedges."
        )
    ),

    Recipe(
        name = R.string.recipe_name_16,
        image = R.drawable.image_16,
        ingredients = mapOf(
            "Chicken" to "250g, sliced",
            "Garlic cloves" to "2, minced",
            "Ground cumin" to "to taste",
            "Ground paprika" to "to taste",
            "Yogurt" to "1/4 cup",
            "Fresh lettuce" to "",
            "Chopped tomatoes" to "",
            "Flatbreads" to "2–4"
        ),
        instructions = listOf(
            "Sauté garlic and add chicken and spices.",
            "Mix yogurt with cumin.",
            "Fill flatbreads with lettuce, chicken, and tomatoes.",
            "Drizzle with yogurt and wrap."
        )
    ),

    Recipe(
        name = R.string.recipe_name_17,
        image = R.drawable.image_17,
        ingredients = mapOf(
            "Bread slices" to "4",
            "Shredded cheese" to "1 cup",
            "Green bell pepper" to "1, diced",
            "Shallot" to "1, diced",
            "Dried oregano" to "to taste",
            "Black pepper" to "to taste"
        ),
        instructions = listOf(
            "Top bread with cheese, pepper, and shallot.",
            "Sprinkle with oregano and pepper.",
            "Bake at 400°F for 8–10 minutes.",
            "Serve hot."
        )
    ),

    Recipe(
        name = R.string.recipe_name_18,
        image = R.drawable.image_18,
        ingredients = mapOf(
            "Tomatoes" to "800g, diced",
            "Onion" to "1, chopped",
            "Garlic cloves" to "2, minced",
            "Vegetable broth" to "2 cups",
            "Salt" to "to taste",
            "Heavy cream (optional)" to ""
        ),
        instructions = listOf(
            "Cook tomatoes, onion, garlic, and broth.",
            "Blend until smooth.",
            "Season with salt.",
            "Serve with cream if desired."
        )
    ),

    Recipe(
        name = R.string.recipe_name_19,
        image = R.drawable.image_19,
        ingredients = mapOf(
            "Potatoes" to "600g, diced",
            "Onion" to "1, chopped",
            "Carrots" to "2, sliced",
            "Vegetable broth" to "1 liter",
            "Salt" to "to taste",
            "Fresh parsley (optional garnish)" to ""
        ),
        instructions = listOf(
            "Cook potatoes, onion, carrots, and broth.",
            "Blend part of the soup.",
            "Season with salt and garnish with parsley."
        )
    ),

    Recipe(
        name = R.string.recipe_name_20,
        image = R.drawable.image_20,
        ingredients = mapOf(
            "Chicken breasts" to "2",
            "Ham" to "2 slices",
            "Sliced cheese" to "2 slices",
            "Flour" to "to taste",
            "Eggs" to "2, beaten",
            "Breadcrumbs" to "to taste",
            "Brown gravy (optional)" to ""
        ),
        instructions = listOf(
            "Stuff chicken with ham and cheese.",
            "Coat with flour, eggs, and breadcrumbs.",
            "Fry at 350°F until golden."
        )
    ),

    Recipe(
        name = R.string.recipe_name_21,
        image = R.drawable.image_21,
        ingredients = mapOf(
            "Flour" to "2 cups",
            "Yeast" to "1 tbsp",
            "Minced meat" to "300g",
            "Onion" to "1, chopped",
            "Tomato paste" to "2 tbsp",
            "Salt" to "1 tsp",
            "Fresh parsley (optional garnish)" to ""
        ),
        instructions = listOf(
            "Prepare the dough and meat filling.",
            "Shape into boat-like flatbreads.",
            "Bake at 475°F until golden.",
            "Garnish with parsley if desired."
        )
    ),

    Recipe(
        name = R.string.recipe_name_22,
        image = R.drawable.image_22,
        ingredients = mapOf(
            "Sugar" to "400g",
            "Water" to "1 cup",
            "Cornstarch" to "100g",
            "Lemon juice" to "1 tbsp",
            "Rosewater or flavoring" to "1 tsp",
            "Food coloring (optional)" to "",
            "Powdered sugar" to "for dusting"
        ),
        instructions = listOf(
            "Boil sugar, water, and lemon juice until dissolved.",
            "Mix cornstarch with water and add to syrup.",
            "Cook until thick and glossy, stir constantly.",
            "Add rosewater and coloring, pour into mold.",
            "Cool, cut into cubes, and dust with powdered sugar."
        )
    ),

    Recipe(
        name = R.string.recipe_name_23,
        image = R.drawable.image_23,
        ingredients = mapOf(
            "Penne" to "200g",
            "Olive oil" to "2 tbsp",
            "Garlic" to "2 cloves, minced",
            "Tomato sauce" to "1 cup",
            "Cherry tomatoes" to "1/2 cup",
            "Fresh parsley (optional garnish)" to ""
        ),
        instructions = listOf(
            "Cook pasta, drain and set aside.",
            "Sauté garlic in oil.",
            "Add tomato sauce and tomatoes.",
            "Combine with pasta and heat through.",
            "Garnish with parsley if desired."
        )
    ),

    Recipe(
        name = R.string.recipe_name_24,
        image = R.drawable.image_24,
        ingredients = mapOf(
            "Spaghetti" to "8 oz",
            "Olive oil" to "2 tbsp",
            "Garlic" to "2 cloves, minced",
            "Tomatoes" to "1 lb, diced",
            "Salt" to "1/2 tsp",
            "Fresh basil (optional garnish)" to ""
        ),
        instructions = listOf(
            "Cook the spaghetti until tender.",
            "Sauté garlic in olive oil.",
            "Add tomatoes and simmer.",
            "Season with salt to taste.",
            "Garnish with basil if desired."
        )
    ),

    Recipe(
        name = R.string.recipe_name_25,
        image = R.drawable.image_25,
        ingredients = mapOf(
            "Raspberries" to "1 cup",
            "Yogurt" to "1/2 cup",
            "Banana" to "1, sliced",
            "Honey" to "1 tbsp",
            "Ice" to "1/2 cup",
            "Fresh mint (optional garnish)" to ""
        ),
        instructions = listOf(
            "Combine raspberries, yogurt, banana, honey, and ice in a blender.",
            "Blend until smooth.",
            "Pour into a glass and garnish with mint."
        )
    ),

    Recipe(
        name = R.string.recipe_name_26,
        image = R.drawable.image_26,
        ingredients = mapOf(
            "Pumpkin" to "4 cups, cubed",
            "Onion" to "1, chopped",
            "Garlic" to "2 cloves, minced",
            "Vegetable broth" to "3 cups",
            "Salt" to "1/2 tsp",
            "Fresh parsley (optional garnish)" to ""
        ),
        instructions = listOf(
            "Cube and cook the pumpkin until soft.",
            "Sauté the onion and garlic.",
            "Add the pumpkin, broth, and salt.",
            "Simmer until vegetables are tender.",
            "Garnish with parsley if desired."
        )
    ),

    Recipe(
        name = R.string.recipe_name_27,
        image = R.drawable.image_27,
        ingredients = mapOf(
            "Flour" to "2 cups",
            "Butter" to "1 cup, cold",
            "Milk" to "1/2 cup",
            "Sugar" to "2 tbsp",
            "Yeast" to "1 packet",
            "Powdered sugar (optional garnish)" to ""
        ),
        instructions = listOf(
            "Mix the ingredients and knead the dough.",
            "Roll out and fold the dough several times.",
            "Shape the dough into croissants.",
            "Proof until doubled in size.",
            "Bake until golden and flaky."
        )
    ),

    Recipe(
        name = R.string.recipe_name_28,
        image = R.drawable.image_28,
        ingredients = mapOf(
            "Flour" to "1 1/2 cups",
            "Sugar" to "1 cup",
            "Cocoa powder" to "1/2 cup",
            "Eggs" to "2",
            "Butter" to "1/2 cup, melted",
            "Frosting" to "1 cup",
            "Colored icing (optional decoration)" to ""
        ),
        instructions = listOf(
            "Mix the dry ingredients in a bowl.",
            "Add the eggs and melted butter.",
            "Pour into pans and bake.",
            "Frost the cooled cake.",
            "Decorate with colored icing if desired."
        )
    ),

    Recipe(
        name = R.string.recipe_name_29,
        image = R.drawable.image_29,
        ingredients = mapOf(
            "Chicken" to "1 whole",
            "Olive oil" to "3 tbsp",
            "Lemon juice" to "3 tbsp",
            "Salt" to "1 tsp",
            "Paprika" to "2 tsp",
            "Fresh parsley (optional garnish)" to ""
        ),
        instructions = listOf(
            "Rub the chicken with oil, lemon juice, salt, and paprika.",
            "Marinate for at least 1 hour.",
            "Grill the chicken over indirect heat.",
            "Rest before serving.",
            "Garnish with parsley if desired."
        )
    ),

    Recipe(
        name = R.string.recipe_name_30,
        image = R.drawable.image_30,
        ingredients = mapOf(
            "Flour" to "1 1/2 cups",
            "Cocoa powder" to "1/4 cup",
            "Sugar" to "1/3 cup",
            "Eggs" to "1",
            "Chocolate glaze" to "1/2 cup",
            "Sprinkles (optional decoration)" to ""
        ),
        instructions = listOf(
            "Mix the ingredients into a dough.",
            "Shape into rings and fry.",
            "Dip in chocolate glaze.",
            "Top with sprinkles if desired."
        )
    )

)