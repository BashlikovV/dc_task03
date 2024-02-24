package by.bashlikovvv.services

import by.bashlikovvv.api.dto.request.UpdateEditorDto
import by.bashlikovvv.api.dto.response.EditorDto

interface EditorService {

    fun create(updateEditorDto: UpdateEditorDto): EditorDto?

    fun update(editorId: Long, updateEditorDto: UpdateEditorDto): EditorDto?

    fun getById(editorId: Long): EditorDto?

    fun getAll(): List<EditorDto?>

    fun delete(editorId: Long): Boolean

    fun getByLogin(login: String): EditorDto?

}