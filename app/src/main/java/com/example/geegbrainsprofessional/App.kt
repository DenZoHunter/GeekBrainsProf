package com.example.geegbrainsprofessional

import android.app.Application
import com.example.geegbrainsprofessional.di.DI
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(
                DI.getModule()
            )
        }
    }

}