package com.example.myapp1.feature.wind_screen.di

import com.example.myapp1.feature.weather_screen.domain.WeatherInteractor
import com.example.myapp1.feature.wind_screen.ui.WindScreenViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val windModule = module {
    viewModel {
WindScreenViewModel(get<WeatherInteractor>())
    }
}