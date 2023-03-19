package xquare.com.application.usecase

import java.util.UUID
import kotlinx.coroutines.runBlocking
import xquare.com.domain.report.Report
import xquare.com.infrastructure.database.ReportRepository
import xquare.com.presentation.api.dto.request.CreateReportRequest

class CreateReportUseCase(
    private val reportRepository: ReportRepository
) {

    fun execute(userId: UUID, request: CreateReportRequest) {
        val report = request.run {
            Report(
                id = null,
                userId = userId,
                reason = reason,
                category = category,
                createdAt = null,
                imageUrl = null
            )
        }

        runBlocking {
            reportRepository.save(report)
        }
    }
}