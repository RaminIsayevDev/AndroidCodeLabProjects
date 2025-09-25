package com.example.bookshelf.network

import com.example.bookshelf.data.model.Book
import retrofit2.http.GET
import retrofit2.http.Path

interface BookshelfApiService {
    @GET("volumes?q=jazz+MIDI")
    suspend fun getBooks(): List<Book>

    @GET("volumes/{volumeId}")
    suspend fun getBookById(@Path("volumeId") volumeId: String): Book

}