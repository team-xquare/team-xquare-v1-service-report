package xquare.com.presentation.api

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import java.util.UUID
import org.koin.ktor.ext.inject
import xquare.com.application.usecase.CreateReportUseCase
import xquare.com.presentation.api.dto.request.CreateReportRequest

fun Application.reportRouting() {
    val createReportUseCase: CreateReportUseCase by inject()

    routing {
        route("/reports") {
            post {
                val request = call.receive<CreateReportRequest>()
                val userId = call.request.headers["Request-User-Id"]

                runCatching {
                    createReportUseCase.execute(UUID.fromString(userId), request)
                }.onSuccess {
                    call.respond(HttpStatusCode.Created, "")
                }.onFailure {
                    call.respond(HttpStatusCode.InternalServerError, it.message!!)
                    it.printStackTrace()
                }
            }
        }
    }
}