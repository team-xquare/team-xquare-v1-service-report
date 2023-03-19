package xquare.com.presentation.api.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateReportResponse(
    @SerialName("report_id")
    val reportId: String
)