package com.example.myapplication

import android.app.Application
import com.facebook.stetho.okhttp3.StethoInterceptor
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.json.serializer.*
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val appModule = module {
    fun provideSharedPref(app: Application): UserPreferences {
        return UserPreferences(app.applicationContext)
    }

    var userPreferences: UserPreferences? = null
    single { provideSharedPref(androidApplication()) }
    fun initKtorClient() = HttpClient(Android) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

//        defaultRequest {
//            header("Content-Type", "application/json; charset=UTF-8")
//        }

        install(DefaultRequest) {
            contentType(ContentType.Application.Json)
            headers {
                //append("Content-Type", "application/json; charset=UTF-8")
                append(
                    HttpHeaders.UserAgent,
                    "ERM Dev 1.0, QSR1.190920.001, Google Android SDK built for x86 Android 10"
                )
                append("Device-Type", "android")
            }
        }


        install(JsonFeature) {
            acceptContentTypes = listOf(

                ContentType.parse("application/vnd.any.response+json"),
                ContentType.parse("application/vnd.any+json")
            )
            serializer = GsonSerializer()
        }
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }
    }
    single { SimpleRepository(get()) }
    single { initKtorClient() }
    single { ApiService(initKtorClient(), get()) }
    single { MainViewModel(get()) }
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