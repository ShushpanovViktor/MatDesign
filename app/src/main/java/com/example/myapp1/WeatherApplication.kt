package com.example.myapp1

import android.app.Application
import com.example.myapp1.feature.weather_screen.di.appModule
import com.example.myapp1.feature.wind_screen.di.windModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherApplication: Application() {

    override fun onCreate(){
        super.onCreate()
        //StartKoin
        startKoin {
            androidLogger()
            androidContext(this@WeatherApplication)
            modules(listOf(appModule, windModule))
        }
    }
}