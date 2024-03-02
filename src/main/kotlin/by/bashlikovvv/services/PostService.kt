package by.bashlikovvv.services

import by.bashlikovvv.api.dto.request.CreatePostDto
import by.bashlikovvv.api.dto.request.UpdatePostDto
import by.bashlikovvv.domain.model.Post

interface PostService {

    suspend fun create(createPostDto: CreatePostDto): Post?

    suspend fun update(postId: Long, updatePostDto: UpdatePostDto): Post?

    suspend fun getById(postId: Long): Post?

    suspend fun getAll(): List<Post?>

    suspend fun delete(postId: Long): Boolean

}