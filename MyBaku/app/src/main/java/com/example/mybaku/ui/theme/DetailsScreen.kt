package com.example.mybaku.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybaku.R
import com.example.mybaku.data.Category
import com.example.mybaku.data.Skeleton
import com.example.mybaku.data.categories
import com.example.mybaku.ui.UiState

@Composable
fun DetailsScreen(
    uiState: UiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(uiState.currentSubCategory.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = stringResource(uiState.currentSubCategory.description),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    // Create a sample UiState for previewing
    val sampleUiState = UiState(
        currentSubCategory = Skeleton(
            id = 4L,
            name = R.string.qala, // Replace with an actual string resource
            image = R.drawable.qala_image, // Replace with an actual drawable resource
            description = R.string.qalaDescription, // Replace with an actual string resource
        ),
        currentCategory = categories[0],
    )
    DetailsScreen(uiState = sampleUiState)
}