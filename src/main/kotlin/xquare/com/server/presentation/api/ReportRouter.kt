package xquare.com.server.presentation.api

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
import xquare.com.server.application.usecase.CreateReportUseCase
import xquare.com.server.infrastructure.error.BaseException
import xquare.com.server.presentation.api.dto.request.CreateReportRequest
import xquare.com.server.presentation.api.dto.response.CreateReportResponse

fun Application.reportRouting() {
    val createReportUseCase: CreateReportUseCase by inject()

    routing {
        route("/reports") {
            post {
                val request = call.receive<CreateReportRequest>()
                val userId = call.request.headers["Request-User-Id"]
                val userRole = call.request.headers["Request-User-Role"]
                val authority = call.request.headers["Request-User-Authorities"]

                var reportId = UUID(0, 0)
                runCatching {
                    reportId = createReportUseCase.execute(UUID.fromString(userId), request)
                }.onSuccess {
                    call.respond(HttpStatusCode.Created, CreateReportResponse(reportId.toString()))
                }.onFailure {
                    call.respond(HttpStatusCode.InternalServerError, BaseException())
                    it.printStackTrace()
                }
            }
        }
    }
}