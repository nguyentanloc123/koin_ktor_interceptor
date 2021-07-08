package com.example.myapplication

import io.ktor.client.request.*

//object UserRepo {
//    suspend fun postLogin(): UserData {
//        return  KtorClient.httpClient.use {
//            it.post("${MainActivity.BaseUrl}/Auth/login"){
//                body = mapOf("password" to "stoneipa","email" to "info@callithome.com","domain" to "callithome")
//                headers{
//                    append("key","value")
//                }
//            }
//        }
//    }
//}