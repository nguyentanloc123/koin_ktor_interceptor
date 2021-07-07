package com.example.myapplication

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

open class ApiService {
    val client = HttpClient(Android){
        install(DefaultRequest){
            headers.append("Content-Type", "application/json")
            //url("www.google.com")
        }
        install(JsonFeature){
            serializer = GsonSerializer()
        }
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }
//        install(Auth) {
//            bearer {
//                loadTokens {
//                    BearerTokens(accessToken = "hello", refreshToken = "world")
//                }
//
//                refreshTokens { response: HttpResponse ->
//                    BearerTokens(accessToken = "hello", refreshToken = "world")
//                }
//            }
//        }
        engine {
            connectTimeout = 100_000
            socketTimeout = 100_000
        }
    }
}