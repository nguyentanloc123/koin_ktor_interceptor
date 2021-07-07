package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.widget.Toast
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    //private val mainViewModel: MainViewModel by viewModel()
    var jobRequest: Job? = null
    val firstPresenter: MySimplePresenter by inject()
    val ktorTest: HttpClient by inject()
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
    @DelicateCoroutinesApi
    private fun somethingUsefulOneAsync() {
        CoroutineScope(Dispatchers.IO).launch {
            val response: HttpResponse? = ktorTest.get("https://ktor.io/")
            if (response?.status?.equals("200") == true) {
                Log.d("Success", "Success")
            } else {
                Log.d("Failed", "Failed")
            }
        }
    }
}