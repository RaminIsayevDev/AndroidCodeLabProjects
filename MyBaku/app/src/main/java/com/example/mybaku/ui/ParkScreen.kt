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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mybaku.data.Skeleton

@Composable
fun ParkScreen(
    uiState: UiState,
    onParkClicked: (Skeleton) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(uiState.parks) { park ->
            Card(
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth(),
                onClick = { onParkClicked(park) }
            ) {
                Row(
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                ) {
                    Image(
                        painter = painterResource(park.image),
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
                        text = stringResource(park.name),
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
fun ParkScreenPreview() {
    val viewModel: MyBakuViewModel = MyBakuViewModel()
    val uiState = viewModel.uiState.collectAsState().value
    ParkScreen(
        uiState = uiState,
        onParkClicked = { park ->
            println("Clicked on shopping center: ${park.name}")
        }
    )
}