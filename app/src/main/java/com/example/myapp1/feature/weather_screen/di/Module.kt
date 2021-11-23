package com.example.myapp1.feature.weather_screen.di

import com.example.myapp1.feature.weather_screen.data.api.WeatherRemoteSource
import com.example.myapp1.feature.weather_screen.data.api.WeatherRepo
import com.example.myapp1.feature.weather_screen.data.api.WeatherRepoImpl
import com.example.myapp1.feature.weather_screen.data.api.WeatherApi
import com.example.myapp1.feature.weather_screen.data.storage.CityDataStorage
import com.example.myapp1.feature.weather_screen.data.storage.CityDataStorageImpl
import com.example.myapp1.feature.weather_screen.data.storage.SettingsRepo
import com.example.myapp1.feature.weather_screen.data.storage.SettingsRepoImpl
import com.example.myapp1.feature.weather_screen.ui.WeatherScreenViewModel
import com.example.myapp1.feature.weather_screen.domain.WeatherInteractor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//?q={city name}&appid={d51a8a7ca67921b871dd5057d52a23bc}
const val BASE_URL = "https://api.openweathermap.org"

val appModule = module {

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single<WeatherApi> {
        get<Retrofit>().create(WeatherApi::class.java)
    }

    single {
        WeatherRemoteSource(get())
    }

    single<WeatherRepo> {
        WeatherRepoImpl(get())
    }

    single {
        WeatherInteractor(get())
    }

    single<CityDataStorage> {
        CityDataStorageImpl(androidContext())
    }

    single<SettingsRepo> {
        SettingsRepoImpl(get())
    }

    viewModel {
        WeatherScreenViewModel(get())
    }
}