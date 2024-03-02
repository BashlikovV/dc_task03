package by.bashlikovvv.data.mapper

import by.bashlikovvv.api.dto.request.CreateTagDto
import by.bashlikovvv.domain.model.Tag
import by.bashlikovvv.util.IMapper

class CreateTagDtoToTagMapper(
    private val id: Long? = null
) : IMapper<CreateTagDto, Tag> {
    override fun mapFromEntity(entity: CreateTagDto): Tag {
        return Tag(
            id = id ?: 0,
            name = entity.name
        )
    }

    override fun mapToEntity(domain: Tag): CreateTagDto {
        return CreateTagDto(
            name = domain.name
        )
    }
}