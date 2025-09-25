package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookshelf.ui.screens.stateHolder.BookUiState

@Composable
fun BookshelfScreen(navController: NavHostController, bookUiState: BookUiState, modifier: Modifier, contentPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = "BooksGridScreen", modifier = modifier) {
        composable(route = "BooksGridScreen") {
            if (bookUiState is BookUiState.Success) {
                BooksGridScreen(books = bookUiState.books.items, modifier = modifier
                    .padding(contentPadding)
                    .fillMaxSize()
                )
            }
        }
        composable(route = "BookItemScreen") {
            if (bookUiState is BookUiState.Success) {
                BookItemScreen(book = bookUiState.currentBook!!, modifier = modifier.padding(contentPadding))
            }
        }
    }
}
