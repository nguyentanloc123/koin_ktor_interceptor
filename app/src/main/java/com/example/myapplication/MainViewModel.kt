package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainViewModel(private val repository: SimpleRepository) : ViewModel() {
    //private val repository = UserPreferences(application)
    //val readFromDataStore = repository.authToken.asLiveData()
    private var _testState =
        MutableStateFlow<ApiResult<LeadFollowUp>>(ApiResult())
    val testState: StateFlow<ApiResult<LeadFollowUp>>
        get() = _testState

    fun test() {
        viewModelScope.launch {
            repository.getFollowUp().collect {
                _testState.value = it
            }
        }
//        runBlocking {
//            repoqsitory.getFollowUp()
//        }
    }

    fun log() {
        Log.d("test", "testttt")
    }
}