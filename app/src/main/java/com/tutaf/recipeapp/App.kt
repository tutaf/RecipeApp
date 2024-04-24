package com.tutaf.recipeapp

import android.app.Application
import com.tutaf.recipeapp.di.appModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}