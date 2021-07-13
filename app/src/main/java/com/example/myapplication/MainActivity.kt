package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.ktor.client.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    companion object {
        var BaseUrl = "http://api.ermservice.com"
    }
    private var _testState =
        MutableStateFlow<ApiResult<LeadFollowUp>>(ApiResult())
    val testState: StateFlow<ApiResult<LeadFollowUp>>
        get() = _testState

    private val mainViewModel: MainViewModel by viewModel()
    var jobRequest: Job? = null
    val simpleRepository: SimpleRepository by inject()
    val firstPresenter: MySimplePresenter by inject()
    private val ktorTest: HttpClient by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_call_api.setOnClickListener {
            mainViewModel.test()
        }
        btn_save_access_token.setOnClickListener{
            clickSaveAuthToken()
        }
    }

    private fun clickSaveAuthToken() {
        runBlocking {
            saveAuthToken("RBMMkJyKEhY0Z")
        }
    }

    suspend fun saveAuthToken(token: String) {
        UserPreferences(this).saveAuthToken(token)
    }

//    suspend fun getAuthToken(): String {
//        return UserPreferences(this).authToken.toString()
//    }
//

}