package xquare.com.domain.report

import java.time.LocalDateTime
import java.util.UUID

data class Report(
    val id: UUID,
    val userId: UUID,
    val reason: String,
    val category: Category,
    val imageUrl: String?,
    val createdAt: LocalDateTime,
)
