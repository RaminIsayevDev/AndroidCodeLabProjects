package com.example.bookshelf.data

import com.example.bookshelf.data.model.Book
import com.example.bookshelf.network.BookshelfApiService

interface BookshelfBooksRepository {
    suspend fun getBooks(): List<Book>
}

class NetworkBookshelfBooksRepository(
    private val bookshelfApiService: BookshelfApiService
) : BookshelfBooksRepository {
    override suspend fun getBooks(): List<Book> = bookshelfApiService.getBooks()
}