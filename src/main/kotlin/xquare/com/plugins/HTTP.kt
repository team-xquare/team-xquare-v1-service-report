package xquare.com.plugins

import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.cors.routing.CORS

fun Application.configureHTTP() {
    install(CORS) {
        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
        allowMethod(HttpMethod.Patch)
        allowHeader(HttpHeaders.Authorization)
        allowHeader(HttpHeaders.ContentType)
        allowHost("service.xquare.app", schemes = listOf("https"))
        allowHost("admin.xquare.app", schemes = listOf("https"))
        allowHost("localhost:3000", schemes = listOf("http"))
        allowHost("localhost:3001", schemes = listOf("http"))
    }
}
