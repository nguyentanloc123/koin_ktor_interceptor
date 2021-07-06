package com.example.myapplication

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class ApiService {
    val client = HttpClient(CIO)
    suspend fun requestApi()
    {
        val response: HttpResponse = client.get("www.google.com")
        {
            headers {
                append(HttpHeaders.Accept, "text/html")
                append(HttpHeaders.Authorization, "token")
                append(HttpHeaders.UserAgent, "ktor client")
            }
            method = HttpMethod.Get
            parameter("price", "asc")
        }
        val client = HttpClient(CIO)
        val byteArrayBody: ByteArray = response.receive()
        println(response.status)
        client.close()
    }

}