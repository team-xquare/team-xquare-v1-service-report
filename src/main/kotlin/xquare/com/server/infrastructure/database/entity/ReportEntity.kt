package xquare.com.server.infrastructure.database.entity

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.SqlExpressionBuilder.isNotNull
import org.jetbrains.exposed.sql.javatime.datetime
import xquare.com.server.domain.report.Category

object ReportEntity : UUIDTable("tbl_report") {
    val userId = uuid("user_id")
    val reason = varchar("reason", 500)
    val category = enumerationByName("category", 10, Category::class)
    val imageUrl = varchar("image_url", 255).nullable()
    val createdAt = datetime("created_at")
}
