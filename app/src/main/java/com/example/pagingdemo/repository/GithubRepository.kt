package com.example.pagingdemo.repository

import androidx.lifecycle.MutableLiveData
import com.example.pagingdemo.data.api.GithubRemoteDataSource
import com.example.pagingdemo.data.db.GitHubLocalDataSource
import com.example.pagingdemo.data.model.Repo
import io.reactivex.Flowable

class GithubRepository(private val service: GithubRemoteDataSource, private val cache: GitHubLocalDataSource) {

    // keep the last requested page. When the request is successful, increment the page number.
    private var lastRequestedPage = 1

    // LiveData of network errors.
    private val networkErrors = MutableLiveData<String>()

    // avoid triggering multiple requests in the same time
    private var isRequestInProgress = false

    fun search(query: String): Flowable<List<Repo>> {
        lastRequestedPage = 1
        requestAndSaveData(query)
        return cache.reposByName(query)
    }

    fun requestMore(query: String) {
        requestAndSaveData(query)
    }

    private fun requestAndSaveData(query: String) {
        service.searchRepos(query, lastRequestedPage, NETWORK_PAGE_SIZE, { repos ->
            cache.insert(repos) {
                lastRequestedPage++
                isRequestInProgress = false
            }
        }, { error ->
            networkErrors.postValue(error)
            isRequestInProgress = false
        })
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}
