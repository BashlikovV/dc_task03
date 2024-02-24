package by.bashlikovvv.di

import by.bashlikovvv.api.dto.response.EditorDto
import by.bashlikovvv.api.dto.response.TweetDto
import by.bashlikovvv.util.BaseRepository
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

val editorsRepositoryQualifier = StringQualifier("editors_repository")
val tweetsRepositoryQualifier = StringQualifier("tweets_repository")

val dataModule = module {

    single<BaseRepository<EditorDto, Long>>(editorsRepositoryQualifier) {
        object : BaseRepository<EditorDto, Long> {
            override val data: MutableList<Pair<Long, EditorDto>> = mutableListOf()

            override fun getLastItem(): EditorDto? {
                var maxKey = 0L
                data.forEach { maxKey = maxOf(it.first, maxKey) }

                return data.find { it.first == maxKey }?.second
            }

            override fun addItem(id: Long, item: EditorDto): EditorDto? {
                val flag = data.add(id to item)

                return if (flag) {
                    item
                } else {
                    null
                }
            }

            override fun removeItem(id: Long): Boolean {
                return data.removeIf { it.first == id }
            }
        }
    }

    single<BaseRepository<TweetDto, Long>>(tweetsRepositoryQualifier) {
        object : BaseRepository<TweetDto, Long> {
            override val data: MutableList<Pair<Long, TweetDto>> = mutableListOf()

            override fun getLastItem(): TweetDto? {
                var maxKey = 0L
                data.forEach { maxKey = maxOf(it.first, maxKey) }

                return data.find { it.first == maxKey }?.second
            }

            override fun removeItem(id: Long): Boolean {
                return data.removeIf { it.first == id }
            }

            override fun addItem(id: Long, item: TweetDto): TweetDto? {
                val flag = data.add(id to item)

                return if (flag) {
                    item
                } else {
                    null
                }
            }
        }
    }

}