package com.example.bookshelf.ui.screens.stateHolder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.data.BookshelfBooksRepository
import com.example.bookshelf.data.model.Book
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class BookshelfViewModel(private val bookshelfBooksRepository: BookshelfBooksRepository) : ViewModel() {
    var booksUiState: BookUiState by mutableStateOf(BookUiState.Loading)
        private set

    init {
        getBooks()
    }

    fun getBooks() {
        viewModelScope.launch {
            booksUiState = BookUiState.Loading
            booksUiState = try {
                BookUiState.Success(bookshelfBooksRepository.getBooks())
            } catch (e: IOException) {
                BookUiState.Error
            } catch (e: HttpException) {
                BookUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookshelfApplication)
                val bookshelfBooksRepository = application.container.bookshelfBooksRepository
                BookshelfViewModel(bookshelfBooksRepository = bookshelfBooksRepository)
            }
        }
    }

}

sealed interface BookUiState {
    data class Success(val books: List<Book>) : BookUiState
    object Error : BookUiState
    object Loading : BookUiState
}