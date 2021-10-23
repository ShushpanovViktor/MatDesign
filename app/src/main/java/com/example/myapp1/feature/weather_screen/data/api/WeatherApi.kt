package com.example.myapp1.feature.weather_screen.data.api

import com.example.myapp1.feature.weather_screen.data.api.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/2.5/weather")
    suspend fun getWeather(
    @Query("q") cityName: String,
    @Query("appid") appId: String = "d51a8a7ca67921b871dd5057d52a23bc",
    @Query("units") units: String = "metric"
): WeatherModel
}