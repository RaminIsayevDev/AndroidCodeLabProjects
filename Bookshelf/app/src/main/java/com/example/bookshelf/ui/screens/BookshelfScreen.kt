package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookshelf.FakePreviewData.bookItem1
import com.example.bookshelf.FakePreviewData.getMockBooks
import com.example.bookshelf.ui.screens.stateHolder.BookUiState

@Composable
fun BookshelfScreen(navController: NavHostController, bookUiState: BookUiState, modifier: Modifier, contentPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = "BooksGridScreen", modifier = modifier) {
        composable(route = "BooksGridScreen") {
            BooksGridScreen(books = bookUiState.books, modifier = modifier
                .padding(contentPadding)
                .fillMaxSize()
            )
        }
        composable(route = "BookItemScreen") {
            BookItemScreen(book = bookItem1, modifier = modifier.padding(contentPadding))
        }
    }
}
