package com.example.pagingdemo.ui

import androidx.lifecycle.MutableLiveData
import com.example.pagingdemo.base.BaseViewModel
import com.example.pagingdemo.repository.GithubRepository

class MainViewModel(private val repository: GithubRepository) : BaseViewModel() {

    private val queryLiveData = MutableLiveData<String>()

    fun searchRepos() {

    }

    fun listScrolled() {

    }
    /**
     * Get the last query value.
     */
    fun lastQueryValue(): String? = queryLiveData.value
}
