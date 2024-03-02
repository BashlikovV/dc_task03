package by.bashlikovvv.data.repository

import by.bashlikovvv.data.local.dao.PostOfflineSource
import by.bashlikovvv.domain.model.Post
import by.bashlikovvv.domain.repository.IPostsRepository

class PostsRepository(
    private val postOfflineSource: PostOfflineSource
) : IPostsRepository {
    override suspend fun create(post: Post): Long {
        return postOfflineSource.create(post)
    }

    override suspend fun read(id: Long): Post? {
        return try {
            postOfflineSource.read(id)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun readAll(): List<Post?> {
        return postOfflineSource.readAll()
    }

    override suspend fun update(id: Long, post: Post): Boolean {
        return postOfflineSource.update(id, post) > 0
    }

    override suspend fun delete(id: Long): Boolean {
        return postOfflineSource.delete(id) > 0
    }
}