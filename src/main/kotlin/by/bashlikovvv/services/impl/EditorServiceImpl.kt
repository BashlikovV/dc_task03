package by.bashlikovvv.services.impl

import by.bashlikovvv.api.dto.request.CreateEditorDto
import by.bashlikovvv.api.dto.request.UpdateEditorDto
import by.bashlikovvv.api.dto.response.EditorDto
import by.bashlikovvv.data.mapper.CreateEditorDtoToEditorMapper
import by.bashlikovvv.data.mapper.UpdateEditorDtoToEditorMapper
import by.bashlikovvv.domain.model.Editor
import by.bashlikovvv.domain.repository.IEditorsRepository
import by.bashlikovvv.services.EditorService

class EditorServiceImpl(
    private val editorRepository: IEditorsRepository
) : EditorService {

    override suspend fun create(createEditorDto: CreateEditorDto): Editor? {
        val editor = CreateEditorDtoToEditorMapper().mapFromEntity(createEditorDto)
        val id = editorRepository.create(editor)

        return editor.copy(id = id)
    }

    override suspend fun update(editorId: Long, updateEditorDto: UpdateEditorDto): Editor? {
        val editor = UpdateEditorDtoToEditorMapper().mapFromEntity(updateEditorDto)
        editorRepository.update(editorId, editor)

        return editor
    }

    override suspend fun getById(editorId: Long): Editor? {
        return editorRepository.read(editorId)
    }

    override suspend fun getAll(): List<Editor?> {
        return editorRepository.readAll()
    }

    override suspend fun delete(editorId: Long): Boolean {
        return editorRepository.delete(editorId) > 0
    }

}