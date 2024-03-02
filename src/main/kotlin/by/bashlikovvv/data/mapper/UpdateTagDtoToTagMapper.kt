package by.bashlikovvv.data.mapper

import by.bashlikovvv.api.dto.request.UpdateTagDto
import by.bashlikovvv.domain.model.Tag
import by.bashlikovvv.util.IMapper

class UpdateTagDtoToTagMapper : IMapper<UpdateTagDto, Tag> {
    override fun mapFromEntity(entity: UpdateTagDto): Tag {
        return Tag(
            id = entity.id,
            name = entity.name
        )
    }

    override fun mapToEntity(domain: Tag): UpdateTagDto {
        return UpdateTagDto(
            id = domain.id,
            name = domain.name
        )
    }
}