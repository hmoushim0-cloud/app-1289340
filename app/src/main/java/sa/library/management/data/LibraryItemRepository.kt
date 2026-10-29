package sa.library.management.data

import sa.library.management.model.LibraryItem
import sa.library.management.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

interface LibraryItemRepository {
    fun getAvailableCatalog(): Flow<List<Book>>
    fun getActiveRequest(): Flow<LibraryItem?>
    suspend fun submitRequest(request: LibraryItem): Result<String>
}

class InMemoryLibraryItemRepository : LibraryItemRepository {
    private val _catalog = MutableStateFlow<List<Book>>(listOf(
        Book("1", "إدارة الكتب", "إضافة وتعديل وحذف الكتب، مع إمكانية التصنيف حسب العنوان والمؤلف.", 5000L, "book"),
        Book("2", "إدارة الأعضاء", "تسجيل بيانات الأعضاء، وتتبع عمليات الإعارة والإرجاع.", 9500L, "user")
    ))
    private val _active = MutableStateFlow<LibraryItem?>(null)

    override fun getAvailableCatalog(): Flow<List<Book>> = _catalog.asStateFlow()
    override fun getActiveRequest(): Flow<LibraryItem?> = _active.asStateFlow()

    override suspend fun submitRequest(request: LibraryItem): Result<String> {
        _active.value = request
        return Result.success(request.requestId)
    }
}
