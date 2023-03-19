package xquare.com.server.infrastructure.database.config

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import xquare.com.server.infrastructure.database.entity.ReportEntity

object DatabaseConfig {
    fun init() {
        val url = System.getenv("DB_URL")
        val driver = System.getenv("DB_DRIVER")
        val username = System.getenv("DB_USERNAME")
        val password = System.getenv("DB_PASSWORD")

        Database.connect(url, driver, username, password)

        transaction {
            SchemaUtils.create(ReportEntity)
        }
    }

    suspend fun <T> query(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}