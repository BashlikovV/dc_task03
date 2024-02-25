package by.bashlikovvv.api.dto.request

import by.bashlikovvv.util.inRange
import kotlinx.serialization.Serializable
import kotlin.jvm.Throws

@Serializable
class UpdatePostDto {

    @Serializable
    val tweetId: Long

    @Serializable
    val content: String

    @Throws(IllegalStateException::class)
    constructor(tweetId: Long, content: String) {
        if (!content.inRange(2, 2048)) { throw IllegalStateException() }

        this.tweetId = tweetId
        this.content = content
    }

}