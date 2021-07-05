package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





    }
    suspend fun runKtor()
    {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("https://ktor.io/")
        println(response.status)
        client.close()
    }
}