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
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybaku.data.Skeleton

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
                        .padding(14.dp)
                        .fillMaxWidth(),
                    onClick = { onAttractionClicked(attraction) }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp)
                    ) {
                        Image(
                            painter = painterResource(attraction.image),
                            contentDescription = null,
                            modifier = androidx.compose.ui.Modifier
                                .align(Alignment.CenterVertically)
                                .size(48.dp),
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
                            textAlign = TextAlign.Left
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
    val viewModel: MyBakuViewModel = MyBakuViewModel()
    val uiState = viewModel.uiState.collectAsState().value
    AttractionsScreen(
        uiState = uiState,
        onAttractionClicked = { attraction ->
            println("Clicked on shopping center: ${attraction.name}")
        }
    )
}