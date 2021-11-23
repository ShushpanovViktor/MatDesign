package com.example.myapp1.feature.weather_screen.data.storage

import android.widget.Toast

class SettingsRepoImpl(private val cityDataStorage: CityDataStorage): SettingsRepo {
    override suspend fun saveCity(city: String) {
        cityDataStorage.saveCity(city)
    }

    override suspend fun getCity(): String {
        return cityDataStorage.getCity()
    }
}