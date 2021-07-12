package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    companion object {
        var BaseUrl = "http://api.ermservice.com"
    }

    //private val mainViewModel: MainViewModel by viewModel()
    var jobRequest: Job? = null
    val firstPresenter: MySimplePresenter by inject()
    private val ktorTest: HttpClient by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_call_api.setOnClickListener {
            clickApi()
        }


    }

    private fun clickApi() {
        runBlocking {
            saveAuthToken("token")
        }
    }

    suspend fun saveAuthToken(token: String) {
        UserPreferences(this).saveAuthToken(token)
    }

    suspend fun getAuthToken(): String {
        return UserPreferences(this).authToken.toString()
    }


}