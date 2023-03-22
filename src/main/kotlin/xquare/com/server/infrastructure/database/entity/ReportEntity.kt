package xquare.com.server.infrastructure.database.entity

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.datetime
import xquare.com.server.domain.report.Category

object ReportEntity : UUIDTable("tbl_report") {
    val userId = uuid("user_id")
    val reason = varchar("reason", 500)
    val category = enumerationByName("category", 255, Category::class)
    val createdAt = datetime("created_at")
}
