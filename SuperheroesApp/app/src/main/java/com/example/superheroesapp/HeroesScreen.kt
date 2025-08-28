package com.example.superheroesapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.superheroesapp.data.Hero
import com.example.superheroesapp.data.heroes
import com.example.superheroesapp.ui.theme.Cabin

@Composable
fun HeroListItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .padding(0.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = dimensionResource(R.dimen.padding_medium))
                    .align(Alignment.CenterVertically)
            ) {
                // Here to add!
                Text(
                    text = stringResource(hero.name), 
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Cabin
                )

                Text(
                    text = stringResource(hero.description),
                    fontFamily = Cabin,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )

            }

            HeroIcon(hero.imageResourceId,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
            )
        }
    }
}

@Composable
fun HeroIcon(
    @DrawableRes imageResourceId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(72.dp)
            .clip(MaterialTheme.shapes.small),
        painter = painterResource(imageResourceId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Preview
@Composable
fun HeroItemPreview() {
    HeroListItem(heroes[5])
}
