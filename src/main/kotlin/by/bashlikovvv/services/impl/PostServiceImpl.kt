package by.bashlikovvv.services.impl

import by.bashlikovvv.api.dto.request.CreatePostDto
import by.bashlikovvv.api.dto.request.UpdatePostDto
import by.bashlikovvv.data.mapper.CreatePostDtoToPostMapper
import by.bashlikovvv.data.mapper.UpdatePostDtoToPostMapper
import by.bashlikovvv.domain.model.Post
import by.bashlikovvv.domain.repository.IPostsRepository
import by.bashlikovvv.services.PostService

class PostServiceImpl(
    private val postRepository: IPostsRepository
) : PostService {
    override suspend fun create(createPostDto: CreatePostDto): Post {
        val post = CreatePostDtoToPostMapper().mapFromEntity(createPostDto)
        val id = postRepository.create(post)

        return post.copy(id = id)
    }

    override suspend fun update(postId: Long, updatePostDto: UpdatePostDto): Post {
        val post = UpdatePostDtoToPostMapper().mapFromEntity(updatePostDto)
        if (!postRepository.update(postId, post)) {

        }

        return post
    }

    override suspend fun getById(postId: Long): Post? {
        return postRepository.read(postId)
    }

    override suspend fun getAll(): List<Post?> {
        return postRepository.readAll()
    }

    override suspend fun delete(postId: Long): Boolean {
        return postRepository.delete(postId)
    }

}