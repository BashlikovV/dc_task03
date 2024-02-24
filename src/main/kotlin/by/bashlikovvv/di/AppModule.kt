package by.bashlikovvv.di

import by.bashlikovvv.api.dto.response.EditorDto
import by.bashlikovvv.api.dto.response.TweetDto
import by.bashlikovvv.services.EditorService
import by.bashlikovvv.services.TweetService
import by.bashlikovvv.services.impl.EditorServiceImpl
import by.bashlikovvv.services.impl.TweetServiceImpl
import by.bashlikovvv.util.BaseRepository
import org.koin.dsl.module

val appModule = module {

    single<EditorService> {
        val repository: BaseRepository<EditorDto, Long> = get(editorsRepositoryQualifier)

        EditorServiceImpl(repository)
    }

    single<TweetService> {
        val repository: BaseRepository<TweetDto, Long> = get(tweetsRepositoryQualifier)

        TweetServiceImpl(repository)
    }

}