package com.example.myapp1.feature.weather_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp1.feature.weather_screen.domain.WeatherInteractor
import com.example.myapp1.feature.weather_screen.domain.model.WeatherDomainModel
import kotlinx.coroutines.launch

class WeatherScreenViewModel(private val interactor: WeatherInteractor): ViewModel()
{
    val livedata: MutableLiveData<WeatherDomainModel> = MutableLiveData()

    fun requestWeather() {
        viewModelScope.launch{
            livedata.postValue(interactor.getWeather())
        }


    }
}