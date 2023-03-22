package xquare.com.server.presentation.exception

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond
import xquare.com.server.domain.common.exception.BaseException

fun Application.exceptionHandler() {
    install(StatusPages) {
        exception<Throwable> { call, _ ->
            call.respond(HttpStatusCode.InternalServerError, BaseException())
        }
    }
}
