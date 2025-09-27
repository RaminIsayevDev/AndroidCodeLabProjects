package com.example.bookshelf.data

import com.example.bookshelf.network.BookshelfApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.kotlinx.serialization.asConverterFactory // Updated import
import kotlinx.serialization.ExperimentalSerializationApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.getValue

interface AppContainer {
    val bookshelfBooksRepository: BookshelfBooksRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://www.googleapis.com/books/v1/"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit = Retrofit.Builder()
        // Ensure Json instance is configured as needed, e.g., with ignoreUnknownKeys
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: BookshelfApiService by lazy {
        retrofit.create(BookshelfApiService::class.java)
    }

    override val bookshelfBooksRepository: BookshelfBooksRepository by lazy {
        NetworkBookshelfBooksRepository(retrofitService)
    }
}