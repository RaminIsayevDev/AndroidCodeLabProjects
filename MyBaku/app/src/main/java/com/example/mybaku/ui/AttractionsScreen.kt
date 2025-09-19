package com.example.mybaku.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybaku.R
import com.example.mybaku.data.Skeleton
import com.example.mybaku.data.categories
import com.example.mybaku.data.local.LocalAttractionsDataProvider.allAttractions
import com.example.mybaku.ui.theme.epundaslab

@Composable
fun AttractionsScreen(
    uiState: UiState,
    onAttractionClicked: (Skeleton) -> Unit,
    modifier: Modifier = Modifier
) {
        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            items(uiState.attractions) { attraction ->
                Card(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp)),
                    onClick = { onAttractionClicked(attraction) }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(attraction.image),
                            contentDescription = null,
                            modifier = androidx.compose.ui.Modifier
                                .align(Alignment.CenterVertically)
                                .size(56.dp)
                                .clip(RoundedCornerShape(16.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(
                            modifier = androidx.compose.ui.Modifier
                                .width(20.dp)
                        )
                        Text(
                            text = stringResource(attraction.name),
                            modifier = androidx.compose.ui.Modifier
                                .align(Alignment.CenterVertically),
                            textAlign = TextAlign.Left,
                            fontFamily = epundaslab,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Spacer(
                            modifier = androidx.compose.ui.Modifier
                                .weight(5f)
                        )
                    }
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun AttractionsScreenPreview() {
    val sampleUiState = UiState(
        attractions = allAttractions, // Populate with sample attractions
        currentSubCategory = Skeleton(
            id = 4L,
            name = R.string.shirvanshaxlarSarayi,
            image = R.drawable.shirvanshahlarsaray_image,
            description = R.string.shirvanshaxlarSarayiDescription,
        ), // Ensure categories[2] is valid
        // ... other properties of UiState initialized with sample data
    )

    AttractionsScreen(
        uiState = sampleUiState,
        onAttractionClicked = { attraction ->
            println("Clicked on attraction: ${attraction.id}") // Use a stable property like id
        }
    )
}
