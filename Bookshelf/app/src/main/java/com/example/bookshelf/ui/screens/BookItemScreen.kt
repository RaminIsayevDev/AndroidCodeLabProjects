package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R // Предполагается, что у вас есть placeholder / error drawable
import com.example.bookshelf.FakePreviewData.bookItem1
import com.example.bookshelf.FakePreviewData.model.Book

@Composable
fun BookItemScreen(book: Book, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        AsyncImage(
            model = book.thumbnail?.replace("http:", "https:"),
            contentDescription = null,
            modifier = Modifier.size(300.dp),
        )
        Text(text = "Title: ${book.title}")

    }
}

@Preview(showBackground = true)
@Composable
fun BookItemScreenPreview() {
    BookItemScreen(book = bookItem1)
}