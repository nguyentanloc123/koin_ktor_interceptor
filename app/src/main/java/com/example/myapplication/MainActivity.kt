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
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    companion object {
        var BaseUrl = "http://api-dev.erm1.com"
    }

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
        //getData()
    }

    //
//    var kJob: Job? = null
//    private suspend fun runKtor() = coroutineScope {
//        ktorTest.get("https://ktor.io/")
//    }
//

    private fun somethingUsefulOneAsync() {
        runBlocking {
            ktorTest.loginData()
        }
//        CoroutineScope(Dispatchers.IO).launch {
//            ktorTest.openData("https://ktor.io/").collect {
//                withContext(Dispatchers.Main) {
//                    Log.d("data", it)
//                }
//            }
//        }
    }

    fun HttpClient.openData(url: String): Flow<String> {
        return flow {
            val response = request<HttpResponse> {
                url(url)
                method = HttpMethod.Get
            }.response
            if (response.status.isSuccess()) {
                Toast.makeText(this@MainActivity, response.toString(), Toast.LENGTH_SHORT).show()
                emit(response.toString())
            }

        }
    }
}