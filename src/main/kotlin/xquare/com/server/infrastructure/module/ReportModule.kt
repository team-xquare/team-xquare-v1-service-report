package xquare.com.server.infrastructure.module

import org.koin.dsl.module
import xquare.com.server.application.report.usecase.CreateReportUseCase
import xquare.com.server.infrastructure.database.ReportImageRepository
import xquare.com.server.infrastructure.database.ReportRepository

val reportModule = module {
    single { ReportRepository() }
    single { ReportImageRepository() }
    single { CreateReportUseCase(get(), get()) }
}
