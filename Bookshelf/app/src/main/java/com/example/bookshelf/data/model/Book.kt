package com.example.bookshelf.data.model

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable
import java.lang.reflect.Modifier
@Serializable
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