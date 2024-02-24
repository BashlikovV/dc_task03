package by.bashlikovvv.api.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class EditorDto(
    val id: Long,
    val login: String,
    private val password: String,
    private val firstname: String,
    private val lastname: String
)