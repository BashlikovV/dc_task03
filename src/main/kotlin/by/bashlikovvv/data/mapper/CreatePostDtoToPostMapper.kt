package by.bashlikovvv.data.mapper

import by.bashlikovvv.api.dto.request.CreatePostDto
import by.bashlikovvv.domain.model.Post
import by.bashlikovvv.util.IMapper

class CreatePostDtoToPostMapper(
    private val id: Long? = null
) : IMapper<CreatePostDto, Post> {
    override fun mapFromEntity(entity: CreatePostDto): Post {
        return Post(
            id = id ?: 0,
            tweetId = entity.tweetId,
            content = entity.content
        )
    }

    override fun mapToEntity(domain: Post): CreatePostDto {
        return CreatePostDto(
            id = domain.id,
            tweetId = domain.tweetId,
            content = domain.content
        )
    }
}