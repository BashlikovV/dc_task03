package by.bashlikovvv.domain.repository

import by.bashlikovvv.domain.model.Post

interface IPostsRepository {

    suspend fun create(post: Post): Long

    suspend fun read(id: Long): Post?

    suspend fun readAll(): List<Post?>

    suspend fun update(id: Long, post: Post): Boolean

    suspend fun delete(id: Long): Boolean

}