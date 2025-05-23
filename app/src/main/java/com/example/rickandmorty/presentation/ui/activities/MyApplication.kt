package com.example.rickandmorty.presentation.ui.activities

import android.app.Application
import com.example.rickandmorty.core.di.networkModule
import com.example.rickandmorty.core.di.repositoryModule
import com.example.rickandmorty.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(networkModule, repositoryModule, viewModelModule)
        }
    }
}