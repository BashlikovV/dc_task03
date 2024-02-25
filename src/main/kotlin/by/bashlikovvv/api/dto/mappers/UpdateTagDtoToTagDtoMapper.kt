package by.bashlikovvv.api.dto.mappers

import by.bashlikovvv.api.dto.request.UpdateTagDto
import by.bashlikovvv.api.dto.response.TagDto
import by.bashlikovvv.util.IMapper

class UpdateTagDtoToTagDtoMapper(
    private val name: String
) : IMapper<UpdateTagDto, TagDto> {
    override fun mapFromEntity(entity: UpdateTagDto): TagDto {
        return TagDto(
            id = entity.id,
            tweetId = entity.tweetId,
            name = entity.name
        )
    }

    override fun mapToEntity(domain: TagDto): UpdateTagDto {
        return UpdateTagDto(
            id = domain.id,
            tweetId = domain.tweetId,
            name = name
        )
    }
}