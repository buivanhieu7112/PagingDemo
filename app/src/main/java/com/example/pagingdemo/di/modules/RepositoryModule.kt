package com.example.pagingdemo.di.modules

import com.example.pagingdemo.data.api.GithubRemoteDataSource
import com.example.pagingdemo.data.api.GithubService
import com.example.pagingdemo.data.db.GitHubLocalDataSource
import com.example.pagingdemo.data.db.RepoDatabase
import com.example.pagingdemo.repository.GithubRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideGithubRepository(githubService: GithubService, repoDatabase: RepoDatabase): GithubRepository {
        return GithubRepository(GithubRemoteDataSource(githubService), GitHubLocalDataSource(repoDatabase.repoDao()))
    }
}
