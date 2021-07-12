package com.example.myapplication

import android.app.Application
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
//        GlobalContext.startKoin {
//            androidContext(this@MyApplication)
//            modules(module {
//                modules(appModule)
//            })
//        }
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule,module1,loggedInModule)
        }
        Stetho.initializeWithDefaults(this);
    }

}