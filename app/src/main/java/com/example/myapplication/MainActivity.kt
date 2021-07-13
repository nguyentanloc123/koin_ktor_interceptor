package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    //private lateinit var mainViewModel: MainViewModel

    companion object {
        var BaseUrl = "http://api.ermservice.com"
    }

    private val mainViewModel: MainViewModel by viewModel()
    var jobRequest: Job? = null
    val simpleRepoqsitory: SimpleRepoqsitory by inject()
    val firstPresenter: MySimplePresenter by inject()
    private val ktorTest: HttpClient by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        mainViewModel = ViewModelProvider(
//            this, ViewModelProvider.AndroidViewModelFactory.getInstance(
//                application)).get(MainViewModel::class.java)


//        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        mainViewModel.readFromDataStore.observe(this, { myName ->
//            textView.text = myName
//        })
        btn_call_api.setOnClickListener {
            clickApi()
        }
        //mainViewModel.test()
    }

    private fun clickApi() {
        runBlocking {
            simpleRepoqsitory.getFollowUp()
        }
    }

    suspend fun saveAuthToken(token: String) {
        UserPreferences(this).saveAuthToken(token)
    }

    suspend fun getAuthToken(): String {
        return UserPreferences(this).authToken.toString()
    }


}