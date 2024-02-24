package by.bashlikovvv.api.dto.request

import by.bashlikovvv.util.inRange
import kotlinx.serialization.Serializable

@Serializable
class UpdateTweetDto @Throws(IllegalStateException::class) constructor(
    @Serializable val id: Int,
    @Serializable val editorId: Long,
    @Serializable val title: String,
    @Serializable val content: String
) {

    init {
        if (!title.inRange(2, 64)) { throw IllegalStateException() }
        if (!content.inRange(4, 2048)) { throw IllegalStateException() }
    }

}