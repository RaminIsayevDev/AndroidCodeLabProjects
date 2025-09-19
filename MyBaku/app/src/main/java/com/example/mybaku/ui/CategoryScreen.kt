package com.example.mybaku.ui

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybaku.data.Category
import com.example.mybaku.data.categories
import com.example.mybaku.ui.theme.epundaslab

@Composable
fun CategoryScreen(
    onCategoryClicked: (Category) -> Unit,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(categories) { category ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                onClick = { onCategoryClicked(category) },
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),

                ) {
                    Icon(
                        painter = painterResource(id = category.icon),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(56.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(20.dp)
                    )
                    Text(
                        text = category.name,
                        modifier = Modifier.align(Alignment.CenterVertically),
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
fun CategoryScreenPreview() {
    CategoryScreen(onCategoryClicked = { category ->
        // In a real app, you'd navigate or perform an action here
        println("Clicked on category: ${category.name}")
    })
}