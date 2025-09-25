package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.bookshelf.data.models.BookItem

@Composable
fun BookItemScreen(book: BookItem, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        AsyncImage(
            model = book.volumeInfo.imageLinks?.thumbnail?.replace("http:", "https:"),
            contentDescription = null,
            modifier = Modifier.size(300.dp),
        )
        Text(text = "Title: ${book.volumeInfo.title}")

    }
}
