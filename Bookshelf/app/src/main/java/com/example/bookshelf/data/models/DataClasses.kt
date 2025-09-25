package com.example.bookshelf.data.models

import com.google.gson.annotations.SerializedName

data class BookItem(
    val kind: String,
    val id: String,
    val etag: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo,
)

data class BooksApiResponse(
    val kind: String,
    val totalItems: Int,
    val items: List<BookItem>,
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val publisher: String,
    val publishedDate: String,
    val description: String,
    val pageCount: Int,
    val dimensions: Dimensions?,
    @SerializedName("averageRating")
    val averageRating: Double?,
    val ratingCount: Int?,
    val imageLinks: ImageLinks?,
    val previewLink: String
)

data class Dimensions(
    val height: String,
    val width: String,
    val thickness: String
)

data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String,
    val medium: String?,
    val large: String?,
    val extraLarge: String?
)