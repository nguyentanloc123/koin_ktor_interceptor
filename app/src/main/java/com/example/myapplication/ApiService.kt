package com.example.myapplication

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.content.*
import io.ktor.features.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ApiService(val httpClient: HttpClient, val pref: UserPreferences) {
    var formatJson = Json {
        ignoreUnknownKeys = true
    }


    suspend inline fun <reified T> get(url: String, list: Any = EmptyBody()): T {
        val response: HttpResponse = httpClient.post(url) {
            headers {
                append("Authorization", "Bearer QBZZP9MDXCdpx")
            }
            body = list
        }
        return formatJson.decodeFromString(response.readText())
    }

    suspend inline fun <reified T> post(url: String, request: Any): T {
        val response: HttpResponse = httpClient.request {
            body = request
            method = HttpMethod.Post
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
