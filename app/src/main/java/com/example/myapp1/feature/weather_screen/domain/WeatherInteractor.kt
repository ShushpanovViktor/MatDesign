package com.example.myapp1.feature.weather_screen.domain

import com.example.myapp1.feature.weather_screen.data.api.WeatherRepo
import com.example.myapp1.feature.weather_screen.domain.model.WeatherDomainModel

class WeatherInteractor(private val repository: WeatherRepo) {
    suspend fun getWeather(): WeatherDomainModel {
        return repository.getWeather()
    }
}