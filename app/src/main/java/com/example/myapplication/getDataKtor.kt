package com.example.myapplication

import io.ktor.client.request.*

class getDataKtor : ApiService() {
    suspend fun getPost(): List<Post> {
        return client.get {
            parameter("user", 123)
        }
    }
}