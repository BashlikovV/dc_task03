package by.bashlikovvv.di

import by.bashlikovvv.domain.repository.IEditorsRepositoryI
import by.bashlikovvv.domain.repository.IPostsRepositoryI
import by.bashlikovvv.domain.repository.ITagsRepositoryI
import by.bashlikovvv.domain.repository.ITweetsRepositoryI
import by.bashlikovvv.services.EditorService
import by.bashlikovvv.services.PostService
import by.bashlikovvv.services.TagService
import by.bashlikovvv.services.TweetService
import by.bashlikovvv.services.impl.EditorServiceImpl
import by.bashlikovvv.services.impl.PostServiceImpl
import by.bashlikovvv.services.impl.TagServiceImpl
import by.bashlikovvv.services.impl.TweetServiceImpl
import org.koin.dsl.module

val appModule = module {

    single<EditorService> {
        val repository: IEditorsRepositoryI = get(editorsRepositoryQualifier)

        EditorServiceImpl(repository)
    }

    single<TweetService> {
        val repository: ITweetsRepositoryI = get(tweetsRepositoryQualifier)

        TweetServiceImpl(repository)
    }

    single<PostService> {
        val repository: IPostsRepositoryI = get(postsRepositoryQualifier)

        PostServiceImpl(repository)
    }

    single<TagService> {
        val repository: ITagsRepositoryI = get(tagsRepositoryQualifier)

        TagServiceImpl(repository)
    }

}