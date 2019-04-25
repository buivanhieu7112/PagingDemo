package com.example.pagingdemo.data.api

import com.example.pagingdemo.data.model.Repo
import io.reactivex.Flowable
import javax.inject.Inject

class GithubRemoteDataSource @Inject constructor(val service: GithubService) {
    fun searchRepos(apiQuery: String, page: Int, itemsPerPage: Int, onSuccess: (repos: List<Repo>) -> Unit,
                    onError: (error: String) -> Unit): Flowable<RepoSearchResponse> {
        return service.searchRepos(apiQuery, page, itemsPerPage)
    }
}
