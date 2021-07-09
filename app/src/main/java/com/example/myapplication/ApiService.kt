package com.example.myapplication

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

//val client = HttpClient(CIO) {
//    install(Logging) {
//        logger = Logger.DEFAULT
//        level = LogLevel.HEADERS
//    }
//}
//val response: HttpResponse = client.request() {
//    headers {
//        append(HttpHeaders.Authorization, pref.authToken.toString())
//        //append(HttpHeaders.UserAgent, "ktor client")
//    }
//}

class ApiService(val httpClient: HttpClient, val pref: UserPreferences) {
    var formatJson = Json {
        ignoreUnknownKeys = true
    }
    suspend inline fun <reified T> get(url: String): T {
        val response: HttpResponse = httpClient.get(url) {
        }
        return formatJson.decodeFromString(response.readText())
    }

    suspend inline fun <reified T> post(url: String, request: Any): T {
        val response: HttpResponse = httpClient.post(url) {
            body = request
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