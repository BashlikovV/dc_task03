package by.bashlikovvv.data.mapper

import by.bashlikovvv.api.dto.request.UpdateTweetDto
import by.bashlikovvv.domain.model.Tweet
import by.bashlikovvv.util.IMapper

class UpdateTweetDtoToTweetMapper(
    private val tweet: Tweet
) : IMapper<UpdateTweetDto, Tweet> {
    override fun mapFromEntity(entity: UpdateTweetDto): Tweet {
        return Tweet(
            id = tweet.id,
            editorId = entity.editorId,
            title = entity.title,
            content = entity.content,
            created = tweet.created,
            modified = tweet.modified
        )
    }

    override fun mapToEntity(domain: Tweet): UpdateTweetDto {
        TODO("Not yet implemented")
    }
}