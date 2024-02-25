package by.bashlikovvv.services.impl

import by.bashlikovvv.api.dto.mappers.PostMapper
import by.bashlikovvv.api.dto.request.UpdatePostDto
import by.bashlikovvv.api.dto.response.PostDto
import by.bashlikovvv.model.Post
import by.bashlikovvv.services.PostService
import by.bashlikovvv.util.BaseRepository

class PostServiceImpl(
    private val postRepository: BaseRepository<PostDto, Long>
) : PostService {
    override fun create(updatePostDto: UpdatePostDto): PostDto? {
        val lastItemId = if (postRepository.data.isEmpty()) {
            -1
        } else {
            postRepository.getLastItem()?.id ?: return null
        }
        val mapper = PostMapper(lastItemId + 1)
        val entity: Post = mapper.mapToEntity(updatePostDto)
        val savedEntity = postRepository.addItem(lastItemId + 1, mapper.mapToDto(entity))

        return savedEntity
    }

    override fun update(postId: Long, updatePostDto: UpdatePostDto): PostDto? {
        val mapper = PostMapper(postId)
        val entity: Post = mapper.mapToEntity(updatePostDto)
        val savedEntity = postRepository.addItem(postId, mapper.mapToDto(entity))

        return savedEntity
    }

    override fun getById(postId: Long): PostDto? {
        return postRepository.getItemById(postId)?.second
    }

    override fun getAll(): List<PostDto?> {
        return postRepository.data.map { it.second }
    }

    override fun delete(postId: Long): Boolean {
        return postRepository.removeItem(postId)
    }
}