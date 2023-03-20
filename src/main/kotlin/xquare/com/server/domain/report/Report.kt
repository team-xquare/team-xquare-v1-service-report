package xquare.com.server.domain.report

import java.time.LocalDateTime
import java.util.UUID

data class Report(
    val id: UUID? = null,
    val userId: UUID,
    val reason: String,
    val category: Category,
    val createdAt: LocalDateTime? = LocalDateTime.now()
)
