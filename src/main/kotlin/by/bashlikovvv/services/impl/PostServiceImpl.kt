package by.bashlikovvv.services.impl

import by.bashlikovvv.api.dto.request.UpdatePostDto
import by.bashlikovvv.api.dto.response.PostDto
import by.bashlikovvv.services.PostService

class PostServiceImpl : PostService {
    override fun create(updatePostDto: UpdatePostDto): PostDto {
        TODO("Not yet implemented")
    }

    override fun update(postId: Long, updatePostDto: UpdatePostDto): PostDto {
        TODO("Not yet implemented")
    }

    override fun getById(postId: Long): PostDto {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<PostDto> {
        TODO("Not yet implemented")
    }

    override fun delete(postId: Long): Boolean {
        TODO("Not yet implemented")
    }
}