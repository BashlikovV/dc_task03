package by.bashlikovvv.domain.repository

import by.bashlikovvv.domain.model.Editor

interface IEditorsRepository {

    suspend fun create(editor: Editor): Long

    suspend fun read(id: Long): Editor?

    suspend fun readAll(): List<Editor?>

    suspend fun update(id: Long, editor: Editor): Int

    suspend fun delete(id: Long): Int

}