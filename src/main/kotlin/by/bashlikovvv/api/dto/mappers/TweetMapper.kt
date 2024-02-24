package by.bashlikovvv.api.dto.mappers

import by.bashlikovvv.api.dto.request.CreateTweetDto
import by.bashlikovvv.api.dto.response.TweetDto
import by.bashlikovvv.model.Tweet
import by.bashlikovvv.util.IMapper
import java.sql.Timestamp
import kotlin.jvm.Throws

class TweetMapper(
    private val editorId: Long,
    private val id: Long,
    private val created: Timestamp,
    private val modified: Timestamp
) : IMapper<Tweet, CreateTweetDto, TweetDto> {

    @Throws(IllegalStateException::class)
    override fun mapFromEntity(entity: Tweet): CreateTweetDto {
        return CreateTweetDto(
            editorId = editorId,
            title = entity.title,
            content = entity.content
        )
    }

    @Throws(IllegalStateException::class)
    override fun mapToEntity(domain: CreateTweetDto): Tweet {
        return Tweet(
            id = id,
            editorId = domain.editorId,
            title = domain.title,
            content = domain.content,
            created = created,
            modified = modified
        )
    }

    @Throws(IllegalStateException::class)
    override fun mapToDto(entity: Tweet): TweetDto {
        return TweetDto(
            id = entity.id,
            editorId = entity.editorId,
            title = entity.title,
            content = entity.content,
            created = entity.created,
            modified = entity.modified
        )
    }
}