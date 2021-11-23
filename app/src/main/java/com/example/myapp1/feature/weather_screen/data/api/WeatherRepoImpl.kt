package com.example.myapp1.feature.weather_screen.data.api

import com.example.myapp1.feature.weather_screen.data.toDomain
import com.example.myapp1.feature.weather_screen.domain.model.WeatherDomainModel

class WeatherRepoImpl(private val source: WeatherRemoteSource): WeatherRepo {
    override suspend fun getWeather(): WeatherDomainModel {
        return source.getWeather().toDomain()
    }
}