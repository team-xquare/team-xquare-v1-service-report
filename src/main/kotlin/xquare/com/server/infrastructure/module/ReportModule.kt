package xquare.com.server.infrastructure.module

import org.koin.dsl.module
import xquare.com.server.application.usecase.CreateReportUseCase
import xquare.com.server.infrastructure.database.ReportRepository

val reportModule = module {
    single { ReportRepository() }
    single { CreateReportUseCase(get()) }
}