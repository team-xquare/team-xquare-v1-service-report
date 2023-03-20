package xquare.com.server.domain.report

import java.time.LocalDateTime
import java.util.UUID

data class ReportImage(
    val id: UUID? = null,
    val report: Report?,
    val imageUrl: String,
    val createdAt: LocalDateTime? = LocalDateTime.now()
)
