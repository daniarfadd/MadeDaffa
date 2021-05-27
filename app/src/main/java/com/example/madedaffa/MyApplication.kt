package com.example.madedaffa

import android.app.Application
import com.example.madedaffa.core.di.databaseModule
import com.example.madedaffa.core.di.networkModule
import com.example.madedaffa.core.di.repositoryModule
import com.example.madedaffa.di.useCaseModule
import com.example.madedaffa.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}