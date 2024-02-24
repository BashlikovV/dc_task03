package by.bashlikovvv.api.dto.mappers

import by.bashlikovvv.api.dto.request.UpdateEditorDto
import by.bashlikovvv.api.dto.response.EditorDto
import by.bashlikovvv.model.Editor
import by.bashlikovvv.util.IMapper
import kotlin.jvm.Throws

class EditorMapper(
    private val id: Long
) : IMapper<Editor, UpdateEditorDto, EditorDto> {

    @Throws(IllegalStateException::class)
    override fun mapFromEntity(entity: Editor): UpdateEditorDto {
        return UpdateEditorDto(
            login = entity.login,
            password = entity.password,
            firstname = entity.firstname,
            lastname = entity.lastname
        )
    }

    @Throws(IllegalStateException::class)
    override fun mapToEntity(domain: UpdateEditorDto): Editor {
        return Editor(
            id = id,
            login = domain.login,
            password = domain.password,
            firstname = domain.firstname,
            lastname = domain.lastname
        )
    }

    @Throws(IllegalStateException::class)
    override fun mapToDto(entity: Editor): EditorDto {
        return EditorDto(
            id = entity.id,
            login = entity.login,
            password = entity.password,
            firstname = entity.firstname,
            lastname = entity.lastname
        )
    }
}