package xquare.com.server.presentation.filter

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationCallPipeline
import io.ktor.server.application.call
import io.ktor.server.response.respond
import xquare.com.server.infrastructure.error.BaseException

fun Application.authenticationFilter() = intercept(ApplicationCallPipeline.Call) {
    val headers = call.request.headers

    val userId = headers["Request-User-Id"]
    val userRole = headers["Request-User-Role"]
    val userAuthorities = headers["Request-User-Authorities"]

    if (userId == null || userRole == null || userAuthorities == null) {
        call.respond(HttpStatusCode.InternalServerError, BaseException(400, "Invalid Header Value"))
    }
    proceed()
}