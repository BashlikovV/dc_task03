package by.bashlikovvv.api.dto.mappers

import by.bashlikovvv.api.dto.request.UpdateTagDto
import by.bashlikovvv.api.dto.response.TagDto
import by.bashlikovvv.model.Tag
import by.bashlikovvv.util.IMapper

class TagMapper(
    private val id: Long,
    private val tweetId: Long
) : IMapper<Tag, UpdateTagDto, TagDto> {
    override fun mapFromEntity(entity: Tag): UpdateTagDto {
        return UpdateTagDto(
            id = id,
            tweetId = tweetId,
            name = entity.name
        )
    }

    override fun mapToEntity(domain: UpdateTagDto): Tag {
        return Tag(
            id = id,
            name = domain.name
        )
    }

    override fun mapToDto(entity: Tag): TagDto {
        return TagDto(
            id = entity.id,
            name = entity.name,
            tweetId = tweetId
        )
    }
}