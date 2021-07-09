package com.example.myapplication

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.koin.dsl.module

val appModule = module {

    //single<HelloRepository> { HelloRepositoryImpl() }

    // Simple Presenter Factory
    //factory { MySimplePresenter(get()) }
    fun initKtorClient() = HttpClient(Android) {
        install(DefaultRequest) {
            headers.append("Content-Type", "application/json")
            headers.append(
                HttpHeaders.Authorization,
                SharedPreferenceHelper().getSharedPreferenceHelper("App").toString()
            )
            //url("www.google.com")
        }

        install(JsonFeature) {
            acceptContentTypes = listOf(
                ContentType.parse("application/vnd.any.response+json"),
                ContentType.parse("application/vnd.any+json")
            )
            serializer = GsonSerializer()
        }
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }
//        install(Auth) {
//            bearer {
//                loadTokens {
//                    BearerTokens(accessToken = "Gj6XNg4vjSlzp")
//                }
//
////                refreshTokens { _: HttpResponse ->
////                    BearerTokens(accessToken = "hello", refreshToken = "world")
////                }
//            }
//        }
        engine {
            connectTimeout = 100_000
            socketTimeout = 100_000
        }
    }
    single { initKtorClient() }

    // single instance of HelloRepository
//        single<HelloRepository> { HelloRepositoryImpl() }
//
//        // Simple Presenter Factory
//        factory { MySimplePresenter(get()) }
}