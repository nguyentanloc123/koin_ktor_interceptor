package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.UserRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel2: ViewModel(){
    val loginUser = MutableStateFlow<UserData?>(null)
    init {
        viewModelScope.launch {
            kotlin.runCatching {
                UserRepo.postLogin()
            }.onSuccess {
                Log.d("Success accessToken", it.accessToken.toString())
                loginUser.value = it
            }.onFailure {  loginUser.value = null }
        }
    }
}