package xquare.com.server.infrastructure.database

import java.time.LocalDateTime
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import xquare.com.server.domain.report.Report
import xquare.com.server.infrastructure.database.config.DatabaseConfig.query
import xquare.com.server.infrastructure.database.entity.ReportEntity

class ReportRepository {

    suspend fun saveAndReturnId(report: Report) = query {
        transaction {
            ReportEntity.insert {
                it[userId] = report.userId
                it[reason] = report.reason
                it[category] = report.category
                it[imageUrl] = report.imageUrl
                it[createdAt] = report.createdAt ?: LocalDateTime.now()
            }[ReportEntity.id]
        }
    }
}