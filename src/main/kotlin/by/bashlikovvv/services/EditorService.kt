package by.bashlikovvv.services

import by.bashlikovvv.api.dto.request.CreateEditorDto
import by.bashlikovvv.api.dto.request.UpdateEditorDto
import by.bashlikovvv.domain.model.Editor

interface EditorService {

    suspend fun create(createEditorDto: CreateEditorDto): Editor?

    suspend fun update(editorId: Long, updateEditorDto: UpdateEditorDto): Editor?

    suspend fun getById(editorId: Long): Editor?

    suspend fun getAll(): List<Editor?>

    suspend fun delete(editorId: Long): Boolean

}