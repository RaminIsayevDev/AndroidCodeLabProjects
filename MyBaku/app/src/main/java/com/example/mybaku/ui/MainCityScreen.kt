package com.example.mybaku.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.mybaku.R
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
        )
        Button(
            onClick = { nextButtonClicked },
            enabled = true,
            modifier = Modifier
        ) {
            Text("Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainCityScreenPreview() {
    MainCityScreen(
        uiState = UiState(),
        nextButtonClicked = {/* TODO: implement onClick functionality */},
        modifier = Modifier
    )
}