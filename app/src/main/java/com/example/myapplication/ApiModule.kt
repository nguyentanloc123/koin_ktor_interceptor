package com.example.myapplication

import android.app.Application
import com.facebook.stetho.okhttp3.StethoInterceptor
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
import io.ktor.client.engine.okhttp.*
import okhttp3.internal.addHeaderLenient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    fun provideSharedPref(app: Application): UserPreferences {
        return UserPreferences(app.applicationContext)
    }

    var userPreferences: UserPreferences? = null
    single { provideSharedPref(androidApplication()) }
    fun initKtorClient() = HttpClient(Android) {
        install(DefaultRequest) {
            headers.append("Content-Type", "application/json")
            headers.append("Device-Type", "android")

            if (!userPreferences?.authToken.toString().isNullOrEmpty()) {
                headers.append(HttpHeaders.Authorization, "Bearer" + { userPreferences?.authToken })
            }
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


    }

    single { initKtorClient() }
    single { ApiService(get(), get()) }
}
val loggedInModule = module {
    single { UserPreferences(get()) }
}


val module1 = module {
    fun initHttp() = HttpClient(OkHttp) {
        engine {

            config {
                followRedirects(true)
            }
            addNetworkInterceptor(StethoInterceptor())
        }
    }
    single { initHttp() }
}