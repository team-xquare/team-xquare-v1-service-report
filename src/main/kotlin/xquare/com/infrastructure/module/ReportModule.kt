package xquare.com.infrastructure.module

import org.koin.dsl.module
import xquare.com.application.usecase.CreateReportUseCase
import xquare.com.infrastructure.database.ReportRepository

val reportModule = module {
    single { ReportRepository() }
    single { CreateReportUseCase(get()) }
}