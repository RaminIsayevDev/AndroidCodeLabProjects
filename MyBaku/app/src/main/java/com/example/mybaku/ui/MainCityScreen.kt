package com.example.mybaku.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
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
import com.example.mybaku.ui.theme.Typography
import com.example.mybaku.ui.theme.epundaslab

@Composable
fun MainCityScreen(
    uiState: UiState,
    nextButtonClicked: () -> Unit,
    modifier: Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    )  {
        Image(
            painter = painterResource(R.drawable.baku_image),
            contentDescription = "Image of Baku",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = stringResource(R.string.bakuDescription),
            style = Typography.bodyLarge,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.text_body_padding)),
            fontFamily = epundaslab,
            fontSize = 20.sp
        )
        Button(
            onClick = { nextButtonClicked() },
            enabled = true,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Next",
                modifier=Modifier
                    .padding(10.dp),
                fontFamily = epundaslab,
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MainCityScreenPreview() {
    val sampleUiState = UiState(
        currentSubCategory = Skeleton(
            id = 4L,
            name = R.string.qala, // Replace with an actual string resource
            image = R.drawable.qala_image, // Replace with an actual drawable resource
            description = R.string.qalaDescription, // Replace with an actual string resource
        ),
    )
    MainCityScreen(
        uiState = sampleUiState,
        nextButtonClicked = {/* TODO: implement onClick functionality */},
        modifier = Modifier
    )
}