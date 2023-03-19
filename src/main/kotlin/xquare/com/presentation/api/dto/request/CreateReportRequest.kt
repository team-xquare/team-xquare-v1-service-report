package xquare.com.presentation.api.dto.request

import kotlinx.serialization.Serializable
import xquare.com.domain.report.Category

@Serializable
data class CreateReportRequest(
    val reason: String,
    val category: Category,
    val imageUrl: String
)
