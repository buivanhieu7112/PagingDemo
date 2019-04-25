package com.example.pagingdemo.data.db

import com.example.pagingdemo.data.model.Repo
import io.reactivex.Flowable
import javax.inject.Inject

class GitHubLocalDataSource @Inject constructor(private val repoDao: RepoDao) {

    fun insert(repos: List<Repo>, insertFinished: ()-> Unit) {
        repoDao.insert(repos)
        insertFinished()
    }

    fun reposByName(name: String): Flowable<List<Repo>> {
        return repoDao.reposByName(name)
    }
}
