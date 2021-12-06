package com.example.GeekBrainsProf

import android.app.Application
import com.example.GeekBrainsProf.di.DI
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
