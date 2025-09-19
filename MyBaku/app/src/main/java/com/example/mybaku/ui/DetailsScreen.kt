package com.example.mybaku.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybaku.R
import com.example.mybaku.data.Skeleton
import com.example.mybaku.data.categories
import com.example.mybaku.ui.theme.epundaslab

@Composable
fun DetailsScreen(
    uiState: UiState,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = painterResource(uiState.currentSubCategory.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = stringResource(uiState.currentSubCategory.description),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 26.dp, vertical = 16.dp),
            fontFamily = epundaslab,
            fontSize = 20.sp
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

    )
    DetailsScreen(uiState = sampleUiState)
}

