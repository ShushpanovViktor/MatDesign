package com.example.myapp1.feature.weather_screen.ui

import com.example.myapp1.base.Event
import com.example.myapp1.feature.weather_screen.domain.model.WeatherDomainModel

data class ViewState(
    val weatherModel: WeatherDomainModel
)

sealed class UIEvent() : Event {
    object RequestWeather: UIEvent()
}

sealed class DataEvent() : Event {
    data class SuccessWeatherRequest(
        val cityName: String,
        val weatherModel: WeatherDomainModel
    ) : DataEvent()

    data class ErrorWeatherRequest(val error: String) : DataEvent()
}