package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.runBlocking


class MainViewModel(private val repoqsitory: SimpleRepoqsitory) : ViewModel() {
    //private val repository = UserPreferences(application)
    //val readFromDataStore = repository.authToken.asLiveData()
    fun test() {
//        runBlocking {
//            repoqsitory.getFollowUp()
//        }
    }
}