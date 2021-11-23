package com.example.myapp1.feature.wind_screen.ui

import com.example.myapp1.base.Event
import com.example.myapp1.feature.weather_screen.domain.model.WindDomainModel

data class ViewState(
    val windDomainModel: WindDomainModel
)

sealed class UIEvent(): Event {
    object GetWind: UIEvent()
}

sealed class DataEvent(): Event {
    data class SuccessWindGetting(val windDomainModel: WindDomainModel): DataEvent()
    data class  ErrorWindGetting(val error: String): DataEvent()
}