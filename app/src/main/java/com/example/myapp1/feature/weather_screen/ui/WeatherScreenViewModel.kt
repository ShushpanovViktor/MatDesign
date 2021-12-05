package com.example.myapp1.feature.weather_screen.ui


import com.example.myapp1.base.BaseViewModel
import com.example.myapp1.base.Event
import com.example.myapp1.feature.weather_screen.data.storage.SettingsRepo
import com.example.myapp1.feature.weather_screen.domain.WeatherInteractor
import com.example.myapp1.feature.weather_screen.domain.model.WeatherDomainModel


class WeatherScreenViewModel(private val interactor: WeatherInteractor): BaseViewModel<ViewState>() {
    init {
        processUiEvent(UIEvent.RequestWeather)
    }

    override fun initialViewState(): ViewState {
        return ViewState(WeatherDomainModel(temperature = "0.0",speed = "0.0"))
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.RequestWeather -> {
                interactor.getWeather()
            }
            is DataEvent.SuccessWeatherRequest -> {
                return previousState.copy(
                    weatherModel = event.weatherModel,
                                    )
            }
            is DataEvent.ErrorWeatherRequest -> {
                return previousState.copy(
                                   )
            }
        }
        return null
    }
}