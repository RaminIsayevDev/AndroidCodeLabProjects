package com.example.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.bookshelf.ui.screens.BookshelfScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.ui.screens.stateHolder.BookshelfViewModel

@Composable
fun BookshelfApp(modifier: Modifier = Modifier) {
    val bookShelfViewModel: BookshelfViewModel = viewModel(factory = BookshelfViewModel.Factory)
    val booksUiState = bookShelfViewModel.booksUiState.collectAsState().value
    Scaffold(modifier = modifier.fillMaxSize(), topBar = { BookshelfTopAppBar(modifier) }) { contentPadding ->

        val navController = rememberNavController()
        BookshelfScreen(navController = navController, contentPadding = contentPadding, bookUiState = booksUiState, modifier = Modifier)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfTopAppBar(modifier: Modifier) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Bookshelf", modifier = modifier, style = MaterialTheme.typography.headlineSmall, textAlign = TextAlign.Center) },
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
    )
}