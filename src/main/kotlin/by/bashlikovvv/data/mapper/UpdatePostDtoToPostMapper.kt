package by.bashlikovvv.data.mapper

import by.bashlikovvv.api.dto.request.UpdatePostDto
import by.bashlikovvv.domain.model.Post
import by.bashlikovvv.util.IMapper

class UpdatePostDtoToPostMapper : IMapper<UpdatePostDto, Post> {
    override fun mapFromEntity(entity: UpdatePostDto): Post {
        return Post(
            id = entity.id,
            tweetId = entity.tweetId,
            content = entity.content
        )
    }

    override fun mapToEntity(domain: Post): UpdatePostDto {
        return UpdatePostDto(
            id = domain.id,
            tweetId = domain.tweetId,
            content = domain.content
        )
    }
}