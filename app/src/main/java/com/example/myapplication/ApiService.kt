package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.content.*
import io.ktor.features.*
import io.ktor.http.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ApiService(val httpClient: HttpClient, val pref: UserPreferences) : ViewModel(){
    var formatJson = Json {
        ignoreUnknownKeys = true
    }
    var accesstoken : String = ""
    suspend inline fun <reified T> get(url: String): T {
        val response: HttpResponse = httpClient.get(url) {}
        return formatJson.decodeFromString(response.readText())
    }

    suspend inline fun <reified T> post(url: String, list: Any = EmptyBody()): T {
        viewModelScope.launch {
            pref.authToken
                .collect {
                    accesstoken = it
                }
        }
        val response: HttpResponse = httpClient.post(url) {
            headers {
                append("Authorization", "Bearer " + accesstoken)
            }
            body = list
        }
        return formatJson.decodeFromString(response.readText())
    }

    suspend inline fun <reified T> delete(url: String): T {
        val response: HttpResponse = httpClient.delete(url) {
        }
        return formatJson.decodeFromString(response.readText())
    }

    suspend inline fun <reified T> put(url: String, request: Any): T {
        val response: HttpResponse = httpClient.delete(url) {
            body = request
        }
        return formatJson.decodeFromString(response.readText())
    }

}
