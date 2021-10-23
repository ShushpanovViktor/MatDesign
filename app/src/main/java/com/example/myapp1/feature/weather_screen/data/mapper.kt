package com.example.myapp1.feature.weather_screen.data

import com.example.myapp1.feature.weather_screen.data.api.model.WeatherModel
import com.example.myapp1.feature.weather_screen.data.api.model.WeatherWindModel
import com.example.myapp1.feature.weather_screen.domain.model.WeatherDomainModel
import com.example.myapp1.feature.weather_screen.domain.model.WindDomainModel

fun WeatherModel.toDomain() = WeatherDomainModel (
    temperature = main.temp,
    speed = wind.speed
)
    //windDomainModel = wind.toDomain()
   //return WeatherDomainModel(
        //this.main.temp
//fun WeatherWindModel.toDomain() = WindDomainModel (
    //speed = speed,
   // degree = deg
    //return WeatherDomainModel(
        //this.main.temp
   // )
