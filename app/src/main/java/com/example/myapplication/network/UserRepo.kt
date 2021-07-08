package com.example.myapplication.network

import com.example.myapplication.LoginData
import com.example.myapplication.MainActivity
import com.example.myapplication.UserData
import io.ktor.client.request.*
import io.ktor.http.*


object UserRepo {
    suspend fun postLogin(): UserData {
        return  KtorClient.httpClient.use {
            it.post("${MainActivity.BaseUrl}/Auth/login"){
                method = HttpMethod.Post
                body = LoginData()
                headers{
                    append("key","value")
                }
            }
        }
    }
}