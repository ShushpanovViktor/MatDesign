package com.example.myapp1.feature.weather_screen.data.api

import com.example.myapp1.feature.weather_screen.data.api.model.WeatherModel
import com.example.myapp1.feature.weather_screen.data.storage.CityProtocol
import com.example.myapp1.feature.weather_screen.data.storage.SettingsRepo
import org.koin.android.ext.android.inject


class WeatherRemoteSource(val api: WeatherApi){
       suspend fun getWeather(): WeatherModel {
        return api.getWeather(CityProtocol.name.toString())
    }
}