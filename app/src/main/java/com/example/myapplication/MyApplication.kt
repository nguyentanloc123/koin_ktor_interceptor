package com.example.myapplication

import android.app.Application
import io.ktor.client.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(module {
                modules(appModule)
            })
        }
    }

}
