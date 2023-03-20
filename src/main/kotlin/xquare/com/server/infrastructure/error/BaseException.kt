package xquare.com.server.infrastructure.error

import kotlinx.serialization.Serializable

@Serializable
data class BaseException(
    val status: Int = 500,
    val message: String = "Internal Server Error"
)