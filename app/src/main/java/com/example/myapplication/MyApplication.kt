package com.example.myapplication

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {
    companion object {
        private var sInstance: MyApplication? = null
        fun getInstance(): MyApplication? {
            return sInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }

}