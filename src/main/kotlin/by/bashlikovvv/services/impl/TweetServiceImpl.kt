package by.bashlikovvv.services.impl

import by.bashlikovvv.api.dto.mappers.TweetMapper
import by.bashlikovvv.api.dto.request.CreateTweetDto
import by.bashlikovvv.api.dto.request.UpdateTweetDto
import by.bashlikovvv.api.dto.response.TweetDto
import by.bashlikovvv.model.Tweet
import by.bashlikovvv.services.TweetService
import by.bashlikovvv.util.BaseRepository
import java.sql.Timestamp

class TweetServiceImpl(
    private val tweetRepository: BaseRepository<TweetDto, Long>
) : TweetService {
    override fun create(createTweetDto: CreateTweetDto): TweetDto? {
        val lastItemId = if (tweetRepository.data.isEmpty()) {
            -1
        } else {
            tweetRepository.getLastItem()?.id ?: return null
        }
        val timeStamp = Timestamp(System.currentTimeMillis())
        val mapper = TweetMapper(
            editorId = createTweetDto.editorId,
            id = lastItemId + 1,
            created = timeStamp,
            modified = timeStamp,
            name = createTweetDto.name ?: ""
        )
        val entity: Tweet = mapper.mapToEntity(UpdateTweetDto(
            editorId = createTweetDto.editorId,
            title = createTweetDto.title,
            content = createTweetDto.content,
            name = createTweetDto.name
        ))
        val savedEntity = tweetRepository.addItem(lastItemId + 1, mapper.mapToDto(entity))

        return savedEntity
    }

    override fun getAll(): List<TweetDto?> {
        return tweetRepository.data.map { it.second }
    }

    override fun getById(tweetId: Long): TweetDto? {
        return tweetRepository.getItemById(tweetId)?.second
    }

    override fun getByEditorId(editorId: Long): TweetDto? {
        return tweetRepository.data.find { it.second.editorId == editorId }?.second
    }

    override fun update(tweetId: Long, updateTweetDto: UpdateTweetDto): TweetDto? {
        val tweet = tweetRepository.getItemById(tweetId)
        tweet ?: return null
        val mapper = TweetMapper(
            editorId = updateTweetDto.editorId,
            id = tweetId,
            created = tweet.second.created,
            modified = Timestamp(System.currentTimeMillis()),
            name = updateTweetDto.name ?: ""
        )
        val entity: Tweet = mapper.mapToEntity(updateTweetDto)
        val savedEntity = tweetRepository.addItem(tweetId, mapper.mapToDto(entity))

        return savedEntity
    }

    override fun delete(tweetId: Long): Boolean {
        return tweetRepository.removeItem(tweetId)
    }
}