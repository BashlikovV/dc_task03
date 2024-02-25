package by.bashlikovvv.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Long,
    val tweetId: Long,
    val content: String
)