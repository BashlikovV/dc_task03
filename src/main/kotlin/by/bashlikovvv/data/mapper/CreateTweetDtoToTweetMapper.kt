package by.bashlikovvv.data.mapper

import by.bashlikovvv.api.dto.request.CreateTweetDto
import by.bashlikovvv.domain.model.Tweet
import by.bashlikovvv.util.IMapper
import java.sql.Timestamp

class CreateTweetDtoToTweetMapper(
    private val id: Long? = null,
    private val name: String? = null
) : IMapper<CreateTweetDto, Tweet> {
    override fun mapFromEntity(entity: CreateTweetDto): Tweet {
        val created = Timestamp(System.currentTimeMillis())

        return Tweet(
            id = id ?: 0,
            editorId = entity.editorId,
            title = entity.title,
            content = entity.content ?: "",
            created = created,
            modified = created
        )
    }

    override fun mapToEntity(domain: Tweet): CreateTweetDto {
        return CreateTweetDto(
            editorId = domain.editorId,
            title = domain.title,
            content = domain.content,
            name = name
        )
    }
}