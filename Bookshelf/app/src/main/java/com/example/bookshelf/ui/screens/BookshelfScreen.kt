package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookshelf.FakePreviewData.bookItem1
import com.example.bookshelf.FakePreviewData.getMockBooks

@Composable
fun BookshelfScreen(navController: NavHostController, modifier: Modifier, contentPadding: PaddingValues) {
    val books = getMockBooks()
    NavHost(navController = navController, startDestination = "BooksGridScreen") {
        composable(route = "BooksGridScreen") {
            BooksGridScreen(books = books, modifier = modifier)
        }
        composable(route = "BookItemScreen") {
            BookItemScreen(book = bookItem1, modifier = modifier)
        }
    }
}