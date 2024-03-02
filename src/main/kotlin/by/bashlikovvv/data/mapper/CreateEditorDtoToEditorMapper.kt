package by.bashlikovvv.data.mapper

import by.bashlikovvv.api.dto.request.CreateEditorDto
import by.bashlikovvv.domain.model.Editor
import by.bashlikovvv.util.IMapper

class CreateEditorDtoToEditorMapper(
    private val id: Long? = null
) : IMapper<CreateEditorDto, Editor> {
    override fun mapFromEntity(entity: CreateEditorDto): Editor {
        return Editor(
            id = id ?: 0,
            login = entity.login,
            password = entity.password,
            firstname = entity.firstname,
            lastname = entity.lastname
        )
    }

    override fun mapToEntity(domain: Editor): CreateEditorDto {
        return CreateEditorDto(
            login = domain.login,
            password = domain.password,
            firstname = domain.firstname,
            lastname = domain.lastname
        )
    }
}