package com.raulastete.kambio

import android.app.Application
import com.raulastete.kambio.di.kambioAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KambioApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KambioApplication)
            androidLogger()
            modules(kambioAppModule)
        }
    }
}