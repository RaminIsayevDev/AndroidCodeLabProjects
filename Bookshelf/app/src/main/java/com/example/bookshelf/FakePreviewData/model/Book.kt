package com.example.bookshelf.FakePreviewData.model

import androidx.compose.runtime.Composable
import java.lang.reflect.Modifier

data class Book(
    val id: String,
    val title: String,
    val authors: List<String>?,
    val thumbnail: String?,
    val publishedDate: String?,
    val pageCount: Int,
    val printedPageCount: Int,
    val language: String,
)