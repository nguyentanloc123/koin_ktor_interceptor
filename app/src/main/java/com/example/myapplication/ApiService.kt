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

class ApiService (val httpClient: HttpClient, val pref: UserPreferences) {
    suspend fun get(url: String){
        val response: HttpResponse = httpClient.get(url) {
            headers {
                append(HttpHeaders.Authorization, pref.authToken.toString())
                //append(HttpHeaders.UserAgent, "ktor client")
            }
        }
    }
}
//open class ApiService {
//    val client = HttpClient(Android) {
//        install(DefaultRequest) {
//            headers.append("Content-Type", "application/json")
//            //url("www.google.com")
//        }
//
//        install(JsonFeature) {
//            acceptContentTypes = listOf(
//                ContentType.parse("application/vnd.any.response+json"),
//                ContentType.parse("application/vnd.any+json")
//            )
//            serializer = GsonSerializer()
//        }
//        install(Logging) {
//            logger = Logger.ANDROID
//            level = LogLevel.ALL
//        }
//        install(Auth) {
//            bearer {
//                loadTokens {
//                    BearerTokens(accessToken = "hello", refreshToken = "world")
//                }
//            }
//        }
//        engine {
//            connectTimeout = 100_000
//            socketTimeout = 100_000
//        }
//    }
//
//}