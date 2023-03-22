package xquare.com.server.presentation.filter

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationCallPipeline
import io.ktor.server.application.call
import io.ktor.server.response.respond
import xquare.com.server.domain.common.exception.BaseException

fun Application.authenticationFilter() = intercept(ApplicationCallPipeline.Call) {
    val userId = call.request.headers["Request-User-Id"]

    if (userId == null) {
        call.respond(HttpStatusCode.Unauthorized, BaseException(401, "Unauthorized"))
    }
    proceed()
}
