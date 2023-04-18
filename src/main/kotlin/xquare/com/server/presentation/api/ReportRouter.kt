package xquare.com.server.presentation.api

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject
import xquare.com.server.application.report.usecase.CreateReportUseCase
import xquare.com.server.presentation.api.dto.request.CreateReportRequest
import xquare.com.server.presentation.api.dto.response.CreateReportResponse
import java.util.UUID

fun Application.reportRouting() {
    val createReportUseCase: CreateReportUseCase by inject()

    routing {
        route("/reports") {
            post {
                val userId = call.request.headers["Request-User-Id"]
                val request = call.receive<CreateReportRequest>()

                val reportId = createReportUseCase.execute(UUID.fromString(userId), request)

                call.respond(HttpStatusCode.Created, CreateReportResponse(reportId.toString()))
            }
        }
    }
}
