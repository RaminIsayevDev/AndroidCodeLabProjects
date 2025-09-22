package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.amphibians.R
import com.example.amphibians.model.Amphibian

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is AmphibiansUiState.Success -> AmphibianListScreen(amphibiansUiState.amphibians, modifier)
        is AmphibiansUiState.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .width(40.dp)
            .size(40.dp),
        painter = painterResource(R.drawable.loading_svgrepo_com),
        contentDescription = stringResource(R.string.loading),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.error_svgrepo_com), contentDescription = "",
            modifier = modifier.width(40.dp)
        )
        Text(text = stringResource(R.string.error_loading), modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}

@Composable
fun ResultScreen(quantity: List<Amphibian>, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = quantity.size.toString())
    }
}

@Composable
fun AmphibianListScreen(amphibians: List<Amphibian>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(4.dp)) {
        items(amphibians){
            amphibian -> AmphibianCard(amphibian)
        }
    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column() {
            Text(
                text = "${amphibian.name} (${amphibian.type})",
                modifier = modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            AsyncImage(
                model = amphibian.imgSrc,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                error = painterResource(R.drawable.error_svgrepo_com),
                placeholder = painterResource(R.drawable.loading_svgrepo_com),
                modifier = modifier.fillMaxWidth()
            )
            Text(
                text = amphibian.description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier.padding(16.dp)
            )
        }
    }
}