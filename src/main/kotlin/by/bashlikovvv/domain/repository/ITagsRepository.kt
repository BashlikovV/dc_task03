package by.bashlikovvv.domain.repository

import by.bashlikovvv.domain.model.Tag

interface ITagsRepository {

    suspend fun create(tag: Tag): Long

    suspend fun read(id: Long): Tag?

    suspend fun readAll(): List<Tag?>

    suspend fun update(id: Long, tag: Tag): Boolean

    suspend fun delete(id: Long): Boolean

}