package xquare.com

import io.ktor.server.application.Application
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import xquare.com.infrastructure.database.config.DatabaseConfig
import xquare.com.infrastructure.module.reportModule
import xquare.com.plugins.configureHTTP
import xquare.com.plugins.configureSerialization
import xquare.com.presentation.api.reportRouting

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
    reportRouting()
    configureSerialization()
    configureHTTP()
}
