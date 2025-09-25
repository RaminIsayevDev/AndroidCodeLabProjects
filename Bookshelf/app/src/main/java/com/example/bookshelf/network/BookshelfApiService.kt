package com.example.bookshelf.network

import com.example.bookshelf.data.models.BookItem
import com.example.bookshelf.data.models.BooksApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BookshelfApiService {
    @GET("volumes?q=jazz+MIDI")
    suspend fun getApiResponse(): BooksApiResponse

    @GET("volumes/{volumeId}")
    suspend fun getIndividualBook(@Path("volumeId") volumeId: String): BookItem
}