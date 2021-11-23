package com.example.myapp1.feature.weather_screen.data.storage

import android.content.Context
import java.security.AccessControlContext

interface CityDataStorage {
    suspend fun saveCity(city: String)
    suspend fun getCity(): String
}