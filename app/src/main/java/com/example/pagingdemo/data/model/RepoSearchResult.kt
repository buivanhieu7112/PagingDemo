package com.example.pagingdemo.data.model

import androidx.lifecycle.LiveData
import io.reactivex.Flowable

data class RepoSearchResult(
    val liveData: Flowable<List<Repo>>,
    val networkErrors: LiveData<String>
)
