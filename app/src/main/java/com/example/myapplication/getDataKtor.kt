package com.example.myapplication

import android.service.autofill.UserData
import android.util.Log
import android.widget.Toast
import com.example.myapplication.MainActivity.Companion.BaseUrl
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private val preferences: UserPreferences
    get() {
        TODO()
    }
suspend fun HttpClient.loginDataWithPreferences() {
    val url = "$BaseUrl/Auth/login"
    try {
        val response = request<User> {
            url(url)
            method = HttpMethod.Post
            body = LoginData()
        }
        if (response.accessToken.toString() != "") {
            Log.d("Success login", response.accessToken)
            saveAuthToken("token")
        } else {
            Log.d("Success", response.toString())
        }
    } catch (e: Exception) {
        Log.d("ExceptionTest", e.message.toString())
    }
}
suspend fun HttpClient.loginData() {
    val url = "$BaseUrl/Auth/login"
    try {
        val response = request<HttpResponse> {
            url(url)
            method = HttpMethod.Post
            body = LoginData()
        }.response
        if (response.status.isSuccess()) {
            Log.d("Success login", response.toString())
        } else {
            Log.d("Success", response.toString())
        }
    } catch (e: Exception) {
        Log.d("ExceptionTest", e.message.toString())
    }
}
suspend fun saveAuthToken(token: String){
    preferences.saveAuthToken(token)
}
suspend fun HttpClient.getFollowUp(): Flow<ApiResult<LeadFollowUp>> = flow {
    val url = "$BaseUrl/leads/follow-up/new-activities"
    //return flow {
    try {
        val response = request<HttpResponse> {
            url(url)
            method = HttpMethod.Get
        }.response
        var dataTexxt = response.readText()
        var data = Json.decodeFromString<ApiResult<LeadFollowUp>>(dataTexxt)
        Log.d("Success", data.toString())
        if (response.status.isSuccess()) {
            emit(data)
        }
    } catch (e: Exception) {
        Log.d("ExceptionTest", e.message.toString())
    }
}