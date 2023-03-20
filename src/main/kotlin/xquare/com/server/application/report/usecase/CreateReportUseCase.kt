package xquare.com.server.application.report.usecase

import java.util.UUID
import xquare.com.server.domain.report.Report
import xquare.com.server.domain.report.ReportImage
import xquare.com.server.infrastructure.database.ReportImageRepository
import xquare.com.server.infrastructure.database.ReportRepository
import xquare.com.server.presentation.api.dto.request.CreateReportRequest

class CreateReportUseCase(
    private val reportRepository: ReportRepository,
    private val reportImageRepository: ReportImageRepository
) {

    suspend fun execute(userId: UUID, request: CreateReportRequest): UUID {
        val report = Report(
            userId = userId,
            reason = request.reason,
            category = request.category
        )

        val reportId = reportRepository.saveAndReturnId(report).value

        if (request.imageUrls.isNotEmpty()) {
            request.imageUrls.forEach {
                val reportImage = ReportImage(
                    report = null,
                    imageUrl = it
                )

                reportImageRepository.save(reportImage, reportId)
            }
        }

        return reportId
    }
}
