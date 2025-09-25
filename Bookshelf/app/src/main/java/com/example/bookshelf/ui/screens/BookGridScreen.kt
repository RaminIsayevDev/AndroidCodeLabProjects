package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.data.model.Book
import com.example.bookshelf.R

@Composable
fun BooksGridScreen(books: List<Book>, modifier: Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp),
    ) {
        items(items = books, key = { book -> book.id }) {
            book -> BookItemCard(
                book,
                modifier = Modifier
                    .padding(3.dp)
            )
        }
    }
}

@Composable
fun BookItemCard(book: Book, modifier: Modifier) {
    Card(
        modifier = modifier.aspectRatio(2f / 3f), // Maintain a 2:3 aspect ratio (width:height)
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(if (book.thumbnail != null) book.thumbnail.replace("http:", "https:") else R.drawable.errorjpg)
                .crossfade(true)
                .build()
            ,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize() // Fill the card bounds
        )
    }
}

