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
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import org.koin.androidx.scope.lifecycleScope

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        somethingUsefulOneAsync()
    }

    var kJob: Job? = null
    private suspend fun runKtor() {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("https://ktor.io/")
        Toast.makeText(this,response.status.toString(),Toast.LENGTH_SHORT).show()
        client.close()
    }

    @DelicateCoroutinesApi
    private fun somethingUsefulOneAsync() = GlobalScope.async {
        runKtor()
    }
}