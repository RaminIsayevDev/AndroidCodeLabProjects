package com.example.bookshelf.data

import com.example.bookshelf.data.models.BookItem
import com.example.bookshelf.data.models.BooksApiResponse
import com.example.bookshelf.network.BookshelfApiService

interface BookshelfBooksRepository {
    suspend fun getApiResponse(): BooksApiResponse
    suspend fun getIndividualBook(volumeId: String): BookItem
}

class NetworkBookshelfBooksRepository(
    private val bookshelfApiService: BookshelfApiService
) : BookshelfBooksRepository {
    override suspend fun getApiResponse(): BooksApiResponse = bookshelfApiService.getApiResponse()
    override suspend fun getIndividualBook(volumeId: String): BookItem = bookshelfApiService.getIndividualBook(volumeId)
}

