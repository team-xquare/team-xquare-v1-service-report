package xquare.com.server.infrastructure.database

import java.time.LocalDateTime
import java.util.UUID
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import xquare.com.server.domain.report.ReportImage
import xquare.com.server.infrastructure.database.config.DatabaseConfig.query
import xquare.com.server.infrastructure.database.entity.ReportImageEntity

class ReportImageRepository {

    suspend fun save(reportImage: ReportImage, reportForeignKey: UUID) = query {
        transaction {
            ReportImageEntity.insert {
                it[reportId] = reportForeignKey
                it[imageUrl] = reportImage.imageUrl
                it[createdAt] = reportImage.createdAt ?: LocalDateTime.now()
            }
        }
    }
}
