package xquare.com.server.presentation.filter

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationCallPipeline
import io.ktor.server.application.call
import io.ktor.server.response.respond
import xquare.com.server.domain.common.exception.BaseException

fun Application.authenticationFilter() = intercept(ApplicationCallPipeline.Call) {
    val headers = call.request.headers

    val userId = headers["Request-User-Id"]
    val userRole = headers["Request-User-Role"]
    val userAuthorities = headers["Request-User-Authorities"]

    if (userId == null || userRole == null || userAuthorities == null) {
        call.respond(HttpStatusCode.Unauthorized, BaseException(401, "Invalid Header Value"))
    }
    proceed()
}
