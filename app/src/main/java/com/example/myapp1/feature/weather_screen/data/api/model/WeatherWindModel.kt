package com.example.myapp1.feature.weather_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class WeatherWindModel (
    @SerializedName("speed")
    val speed: String,
    @SerializedName("deg")
    val deg: String
    )