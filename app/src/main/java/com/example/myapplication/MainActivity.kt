package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    //private val mainViewModel: MainViewModel by viewModel()
    var jobRequest: Job? = null
    val firstPresenter: MySimplePresenter by inject()
    private val ktorTest: HttpClient by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //mainViewModel.test()
        //Log.d("Success",firstPresenter.sayHello().toString())
        //firstPresenter.sayHello()
        somethingUsefulOneAsync()
    }

    //
//    var kJob: Job? = null
//    private suspend fun runKtor() = coroutineScope {
//        ktorTest.get("https://ktor.io/")
//    }
//
    private fun somethingUsefulOneAsync() {
        CoroutineScope(Dispatchers.IO).launch {
            ktorTest.openData("http://ktor.io/").collect {
                withContext(Dispatchers.Main) {
                    Log.d("data", it)
                }
            }

        }
    }

    suspend fun HttpClient.openData(url: String): Flow<String> {
        return flow {
            val response = request<HttpResponse> {
                url(url)
                method = HttpMethod.Get
            }.response
            emit(response.toString())

        }
    }
}