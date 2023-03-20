package xquare.com

import io.ktor.server.application.Application
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import xquare.com.server.infrastructure.database.config.DatabaseConfig
import xquare.com.server.infrastructure.module.reportModule
import xquare.com.plugins.configureHTTP
import xquare.com.plugins.configureSerialization
import xquare.com.server.presentation.api.reportRouting
import xquare.com.server.presentation.filter.authenticationFilter

fun main(args: Array<String>) {
    stopKoin()
    startKoin {
        val modules = arrayOf(reportModule)

        modules(*modules)
    }

    io.ktor.server.netty.EngineMain.main(args)
}


@Suppress("unused")
fun Application.module() {
    DatabaseConfig.init()
    configureSerialization()
    configureHTTP()
    authenticationFilter()
    reportRouting()
}
