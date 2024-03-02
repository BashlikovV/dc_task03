package by.bashlikovvv.data.repository

import by.bashlikovvv.data.local.dao.TweetOfflineSource
import by.bashlikovvv.domain.model.Tweet
import by.bashlikovvv.domain.repository.ITweetsRepository

class TweetsRepository(
    private val tweetOfflineSource: TweetOfflineSource
) : ITweetsRepository {
    override suspend fun create(tweet: Tweet): Long {
        return tweetOfflineSource.create(tweet)
    }

    override suspend fun read(id: Long): Tweet? {
        return try {
            tweetOfflineSource.read(id)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun readAll(): List<Tweet?> {
        return tweetOfflineSource.readAll()
    }

    override suspend fun readBYEditorId(editorId: Long): List<Tweet?> {
        return tweetOfflineSource.readByEditorId(editorId)
    }

    override suspend fun update(id: Long, tweet: Tweet): Int {
        return tweetOfflineSource.update(id, tweet)
    }

    override suspend fun delete(id: Long): Int {
        return tweetOfflineSource.delete(id)
    }
}