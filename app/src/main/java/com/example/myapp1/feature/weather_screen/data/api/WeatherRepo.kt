package com.example.myapp1.feature.weather_screen.data.api

import com.example.myapp1.feature.weather_screen.domain.model.WeatherDomainModel

interface WeatherRepo {
    suspend fun getWeather(): WeatherDomainModel
}