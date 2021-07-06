package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.widget.Toast
import androidx.lifecycle.viewmodel.compose.viewModel
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    var jobRequest: Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var kJob: Job? = null
    private suspend fun runKtor() = coroutineScope {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("https://ktor.io/")
        Log.d("test", response.status.toString())
        client.close()
    }

    @DelicateCoroutinesApi
    private fun somethingUsefulOneAsync() = GlobalScope.async {
        runKtor()
    }
}