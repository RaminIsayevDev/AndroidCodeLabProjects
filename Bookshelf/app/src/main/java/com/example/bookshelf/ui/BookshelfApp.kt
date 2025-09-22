package com.example.bookshelf.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.bookshelf.ui.screens.BookshelfScreen

@Composable
fun BookshelfApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier) { contentPadding ->
        val navController = rememberNavController()
        BookshelfScreen(navController = navController, contentPadding = contentPadding, modifier = modifier)
    }
}