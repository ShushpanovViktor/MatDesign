package com.example.myapp1.feature.weather_screen.data.storage

import androidx.datastore.preferences.core.stringPreferencesKey

object CityProtocol {
    var name = stringPreferencesKey("city")
}