package com.example.bookshelf.FakePreviewData

import com.example.bookshelf.data.model.Book

fun getMockBooks(): List<Book> {
    return listOf(
        Book(
            id = "dXhhMMSL3RoC",
            title = "Trippings in Author-land",
            authors = listOf("Emily Chubbuck Judson"),
            thumbnail = "https://books.google.com/books/content?id=dXhhMMSL3RoC&printsec=frontcover&img=1&zoom=5&edge=curl",
            publishedDate = "2023",
            pageCount = 1,
            printedPageCount = 1,
            language = "en"
        ),
        Book(
            id = "another_id",
            title = "The Lord of the Rings",
            authors = listOf("J.R.R. Tolkien"),
            thumbnail = "https://books.google.com/books/content?id=another_id&printsec=frontcover&img=1&zoom=5&edge=curl",
            publishedDate = "1954",
            pageCount = 1178,
            printedPageCount = 1178,
            language = "en"
        ),
        Book(
            id = "third_id",
            title = "A Book with No Authors",
            authors = null,
            thumbnail = null,
            publishedDate = null,
            pageCount = 1,
            printedPageCount = 1,
            language = "en"
        )
    )
}