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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.mybaku.data.local.LocalShoppingcenterDataProvider.allShoppingCenters
import com.example.mybaku.ui.theme.epundaslab


@Composable
fun ShoppingScreen(
    uiState: UiState,
    onShoppingClicked: (Skeleton) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(uiState.shoppingCenters) { shopCenter ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                onClick = { onShoppingClicked(shopCenter) }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(shopCenter.image),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(56.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(
                        modifier = Modifier
                            .width(20.dp)
                    )
                    Text(
                        text = stringResource(shopCenter.name),
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        textAlign = TextAlign.Left,
                        fontFamily = epundaslab,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(
                        modifier = Modifier
                            .weight(5f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingScreenPreview() {
    val sampleUiState = UiState(
        shoppingCenters = allShoppingCenters, // Populate the 'parks' field
        currentSubCategory = Skeleton(
            id = 4L,
            name = R.string.denizMall,
            image = R.drawable.denizmall_image,
            description = R.string.denizMallDescription,
        ),
        // ... other properties of UiState initialized with sample data
    )

    ShoppingScreen(
        uiState = sampleUiState,
        onShoppingClicked = { shoppingCenter ->
            println("Clicked on park: ${shoppingCenter.name}")
        }
    )
}
