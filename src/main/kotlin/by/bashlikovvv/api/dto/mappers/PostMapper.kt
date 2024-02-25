package by.bashlikovvv.api.dto.mappers

import by.bashlikovvv.api.dto.request.UpdatePostDto
import by.bashlikovvv.api.dto.response.PostDto
import by.bashlikovvv.model.Post
import by.bashlikovvv.util.IMapper

class PostMapper(
    private val id: Long
) : IMapper<Post, UpdatePostDto, PostDto> {
    override fun mapFromEntity(entity: Post): UpdatePostDto {
        return UpdatePostDto(
            tweetId = entity.tweetId,
            content = entity.content
        )
    }

    override fun mapToEntity(domain: UpdatePostDto): Post {
        return Post(
            id = id,
            tweetId = domain.tweetId,
            content = domain.content
        )
    }

    override fun mapToDto(entity: Post): PostDto {
        return PostDto(
            id = entity.id,
            tweetId = entity.tweetId,
            content = entity.content
        )
    }
}