package by.bashlikovvv.data.repository

import by.bashlikovvv.data.local.dao.TagOfflineSource
import by.bashlikovvv.domain.model.Tag
import by.bashlikovvv.domain.repository.ITagsRepository

class TagsRepository(
    private val tagOfflineSource: TagOfflineSource
) : ITagsRepository {
    override suspend fun create(tag: Tag): Long {
        return tagOfflineSource.create(tag)
    }

    override suspend fun read(id: Long): Tag? {
        return try {
            tagOfflineSource.read(id)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun readAll(): List<Tag?> {
        return tagOfflineSource.readAll()
    }

    override suspend fun update(id: Long, tag: Tag): Boolean {
        return tagOfflineSource.update(id, tag) > 0
    }

    override suspend fun delete(id: Long): Boolean {
        return tagOfflineSource.delete(id) > 0
    }
}