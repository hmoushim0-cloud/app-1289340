package sa.library.management.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import sa.library.management.data.LibraryItemRepository
import sa.library.management.model.LibraryItem
import sa.library.management.model.Book
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LibraryItemViewModel(
    private val repository: LibraryItemRepository
) : ViewModel() {
    val catalog: StateFlow<List<Book>> = repository.getAvailableCatalog()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val activeRequest: StateFlow<LibraryItem?> = repository.getActiveRequest()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun submitNewOrder(request: LibraryItem) {
        viewModelScope.launch {
            repository.submitRequest(request)
        }
    }
}
