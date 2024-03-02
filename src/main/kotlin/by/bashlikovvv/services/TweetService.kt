package by.bashlikovvv.services

import by.bashlikovvv.api.dto.request.CreateTweetDto
import by.bashlikovvv.api.dto.request.UpdateTweetDto
import by.bashlikovvv.api.dto.response.TweetDto
import by.bashlikovvv.domain.model.Tweet

interface TweetService {

    suspend fun create(createTweetDto: CreateTweetDto): Tweet?

    suspend fun getAll(): List<Tweet?>

    suspend fun getById(tweetId: Long): Tweet?

    suspend fun getByEditorId(editorId: Long): Tweet?

    suspend fun update(tweetId: Long, updateTweetDto: UpdateTweetDto): Tweet?

    suspend fun delete(tweetId: Long): Boolean

}