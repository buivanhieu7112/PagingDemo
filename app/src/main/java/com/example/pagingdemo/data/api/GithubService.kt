package com.example.pagingdemo.data.api

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repository?sort=stars")
    fun searchRepos(@Query("q") query: String,
                    @Query("page") page: Int,
                    @Query("per_page") itemsPerPage: Int): Flowable<RepoSearchResponse>
}
