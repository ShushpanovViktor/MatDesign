package com.example.myapp1.feature.wind_screen.ui

import com.example.myapp1.base.BaseViewModel
import com.example.myapp1.base.Event
import com.example.myapp1.feature.weather_screen.domain.WeatherInteractor
import com.example.myapp1.feature.weather_screen.domain.model.WindDomainModel

class WindScreenViewModel(private val interactor: WeatherInteractor): BaseViewModel<ViewState>(){
    init {
        processUiEvent(UIEvent.GetWind)
    }

    override fun initialViewState(): ViewState {
        return ViewState(WindDomainModel(speed = "0.0", degree = "0.0"))
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.GetWind -> {
                    interactor.getWeather()
            }
            is DataEvent.SuccessWindGetting -> {
                return previousState.copy(windDomainModel = event.windDomainModel)
            }
            is DataEvent.ErrorWindGetting -> {
                return previousState.copy()
            }
        }
        return null
    }
}