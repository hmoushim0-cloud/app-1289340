package sa.library.management.model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val id: String,
    val title: String,
    val description: String,
    val priceMinorUnits: Long,
    val iconVector: String = "verified"
)

@Serializable
data class LibraryItem(
    val requestId: String,
    val items: List<Book>,
    val customerPhone: String,
    val totalAmountMinorUnits: Long,
    val status: LibraryItemStatus = LibraryItemStatus.PENDING,
    val createdAtEpochMs: Long = System.currentTimeMillis()
)

enum class LibraryItemStatus {
    PENDING,
    ACCEPTED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}
