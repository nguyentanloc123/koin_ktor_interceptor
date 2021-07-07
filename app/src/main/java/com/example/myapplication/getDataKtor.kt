package com.example.myapplication

import android.util.Log
import com.example.myapplication.MainActivity.Companion.BaseUrl
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import java.lang.Exception


suspend fun HttpClient.loginData() {
    val url = "$BaseUrl/Auth/login"
    try {
        val response = request<HttpResponse> {
            url(url)
            method = HttpMethod.Post
            body = LoginData()
        }.response
        if (response.status.isSuccess()) {
            Log.d("Success", response.toString())
        } else {
            Log.d("Success", response.toString())
        }
    } catch (e: Exception) {
        Log.d("ExceptionTest", e.message.toString())
    }


//        runBlocking {
//            try {
//                var data2: HttpResponse = ktorTest.get(url) {
//                }
//                val data2Json = data2.readText()
//            } catch (e: Exception) {
//                Log.d("exception", "${e}")
//            }
//        }
}