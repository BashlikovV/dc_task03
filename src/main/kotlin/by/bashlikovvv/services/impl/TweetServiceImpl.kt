package by.bashlikovvv.services.impl

import by.bashlikovvv.api.dto.request.CreateTweetDto
import by.bashlikovvv.api.dto.request.UpdateTweetDto
import by.bashlikovvv.data.mapper.CreateTweetDtoToTweetMapper
import by.bashlikovvv.data.mapper.UpdateTweetDtoToTweetMapper
import by.bashlikovvv.domain.model.Tweet
import by.bashlikovvv.domain.repository.ITweetsRepository
import by.bashlikovvv.services.TweetService

class TweetServiceImpl(
    private val tweetRepository: ITweetsRepository
) : TweetService {
    override suspend  fun create(createTweetDto: CreateTweetDto): Tweet {
        val tweet = CreateTweetDtoToTweetMapper().mapFromEntity(createTweetDto)
        val id = tweetRepository.create(tweet)

        return tweet.copy(id = id)
    }

    override suspend  fun getAll(): List<Tweet?> {
        return tweetRepository.readAll()
    }

    override suspend  fun getById(tweetId: Long): Tweet? {
        return tweetRepository.read(tweetId)
    }

    override suspend  fun getByEditorId(editorId: Long): Tweet? {
        return tweetRepository.readBYEditorId(editorId).first()
    }

    override suspend  fun update(tweetId: Long, updateTweetDto: UpdateTweetDto): Tweet? {
        var tweet = tweetRepository.read(tweetId) ?: return null
        tweet = UpdateTweetDtoToTweetMapper(tweet).mapFromEntity(updateTweetDto)
        tweetRepository.update(tweetId, tweet)

        return tweet
    }

    override suspend  fun delete(tweetId: Long): Boolean {
        return tweetRepository.delete(tweetId) > 0
    }

}