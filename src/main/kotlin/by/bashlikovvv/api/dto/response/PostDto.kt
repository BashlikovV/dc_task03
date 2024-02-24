package by.bashlikovvv.api.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class PostDto(
    private val id: Long,
    private val tweetId: Long,
    private val content: String
)