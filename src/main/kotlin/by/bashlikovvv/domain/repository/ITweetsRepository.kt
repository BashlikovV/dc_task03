package by.bashlikovvv.domain.repository

import by.bashlikovvv.domain.model.Tweet

interface ITweetsRepository {

    suspend fun create(tweet: Tweet): Long

    suspend fun read(id: Long): Tweet?

    suspend fun readAll(): List<Tweet?>

    suspend fun readBYEditorId(editorId: Long): List<Tweet?>

    suspend fun update(id: Long, tweet: Tweet): Int

    suspend fun delete(id: Long): Int

}