package com.example.myapplication

import io.ktor.client.request.*
import kotlin.text.get

class getDataKtor : ApiService() {
    suspend fun getPost(): List<Post> {
        return client.get {

        }
    }
}