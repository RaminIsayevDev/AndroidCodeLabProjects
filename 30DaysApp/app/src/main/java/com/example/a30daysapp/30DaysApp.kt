package com.example.a30daysapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a30daysapp.data.Recipe
import com.example.a30daysapp.data.recipes
import com.example.a30daysapp.ui.theme.PlayFairDisplay


@Composable
fun RecipeItem(modifier: Modifier = Modifier, recipe: Recipe) {
    var expanded by remember { mutableStateOf(false) }

    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.card_padding))
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Text(
                text = stringResource(recipe.name),
                modifier = Modifier,
                fontFamily = PlayFairDisplay,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            RecipeIcon(recipe.image, recipe.name,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clip(MaterialTheme.shapes.large)
            )

            Spacer(modifier = Modifier.size(10.dp))

            if (expanded) {
                // Here we write the ingredients and instructions
                RecipeInformation(recipe.ingredients, recipe.instructions)
            }

            Spacer(modifier = Modifier.size(10.dp))

            Row(
                modifier = Modifier
            ) {
                Spacer(modifier = Modifier.weight(4f))

                RecipeButton(expanded = expanded, onClick = { expanded = !expanded }, modifier = Modifier.weight(2.5f))
            }

        }
    }
}

@Composable
fun RecipeIcon(
    @DrawableRes recipeIcon: Int,
    @StringRes recipeName: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .fillMaxWidth(),
        painter = painterResource(recipeIcon),
        contentDescription = stringResource(recipeName),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun RecipeButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        if (expanded) Text(text = "Show less") else Text(text = "Show more")
    }
}


// Make sure you have this import if it's not already there
// import com.example.a30daysapp.R // Or your app's R file
@Composable
fun RecipeInformation(
    ingredients: Map<String, String>,
    instructions: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // Ingredients Section
        Text(
            text = stringResource(R.string.ingredients_title),
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small))) // e.g., 8.dp

        // Iterate over the ingredients map
        ingredients.forEach { (ingredientName, quantity) ->
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "$ingredientName:",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.weight(1f) // Adjust weight as needed
                )
                Text(
                    text = quantity,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.weight(2f) // Adjust weight as needed
                )
            }
            Spacer(modifier = Modifier.height(4.dp)) // Small space between ingredients
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium))) // e.g., 16.dp

        // Instructions Section
        Text(
            text = stringResource(R.string.instructions_title), // Ensure this string resource exists
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

        // Iterate over the instructions list
        instructions.forEachIndexed { index, instruction ->
            Text(
                text = "${index + 1}. $instruction", // Numbering the instructions
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp)) // Small space between instruction steps
        }
    }
}


@Preview
@Composable
fun RecipeItemPreview() {
    RecipeItem(modifier = Modifier, recipe = recipes[0])
}