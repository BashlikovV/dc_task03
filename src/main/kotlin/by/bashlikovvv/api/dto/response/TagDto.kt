package by.bashlikovvv.api.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class TagDto(
    private val id: Long,
    private val name: String
)