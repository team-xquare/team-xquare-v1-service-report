package xquare.com.server.infrastructure.database.entity

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.datetime

object ReportImageEntity : UUIDTable("tbl_report_image") {
    val reportId = reference("report_id", ReportEntity.id)
    val imageUrl = varchar("image_url", 255)
    val createdAt = datetime("created_at")
}
