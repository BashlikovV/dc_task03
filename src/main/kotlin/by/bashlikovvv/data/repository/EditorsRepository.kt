package by.bashlikovvv.data.repository

import by.bashlikovvv.data.local.dao.EditorOfflineSource
import by.bashlikovvv.domain.model.Editor
import by.bashlikovvv.domain.repository.IEditorsRepository

class EditorsRepository(
    private val editorOfflineSource: EditorOfflineSource
) : IEditorsRepository {
    override suspend fun create(editor: Editor): Long {
        return editorOfflineSource.create(editor)
    }

    override suspend fun read(id: Long): Editor? {
        return try {
            editorOfflineSource.read(id)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun readAll(): List<Editor?> {
        return editorOfflineSource.readAll()
    }

    override suspend fun update(id: Long, editor: Editor): Int {
        return editorOfflineSource.update(id, editor)
    }

    override suspend fun delete(id: Long): Int {
        return editorOfflineSource.delete(id)
    }

}