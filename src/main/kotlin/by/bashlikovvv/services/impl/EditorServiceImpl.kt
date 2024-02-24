package by.bashlikovvv.services.impl

import by.bashlikovvv.api.dto.mappers.EditorMapper
import by.bashlikovvv.api.dto.request.UpdateEditorDto
import by.bashlikovvv.api.dto.response.EditorDto
import by.bashlikovvv.model.Editor
import by.bashlikovvv.services.EditorService
import by.bashlikovvv.util.BaseRepository

class EditorServiceImpl(
    private val editorRepository: BaseRepository<EditorDto, Long>
) : EditorService {

    override fun create(updateEditorDto: UpdateEditorDto): EditorDto? {
        val lastItemId = if (editorRepository.data.isEmpty()) {
            -1
        } else {
            editorRepository.getLastItem()?.id ?: return null
        }
        val mapper = EditorMapper(lastItemId + 1)
        val entity: Editor = mapper.mapToEntity(updateEditorDto)
        val savedEntity = editorRepository.addItem(lastItemId + 1, mapper.mapToDto(entity))

        return savedEntity
    }

    override fun update(editorId: Long, updateEditorDto: UpdateEditorDto): EditorDto? {
        val mapper = EditorMapper(editorId)
        val entity: Editor = mapper.mapToEntity(updateEditorDto)
        val savedEntity = editorRepository.addItem(editorId, mapper.mapToDto(entity))

        return savedEntity
    }

    override fun getById(editorId: Long): EditorDto? {
        val savedEntity = editorRepository.getItemById(editorId)

        return savedEntity?.second
    }

    override fun getAll(): List<EditorDto> {
        return editorRepository.data.map { it.second }
    }

    override fun delete(editorId: Long): Boolean {
        return editorRepository.removeItem(editorId)
    }

    override fun getByLogin(login: String): EditorDto? {
        return editorRepository.data.find { it.second.login == login }?.second
    }
}