package com.example.myapp1.feature.weather_screen.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp1.R
import com.example.myapp1.feature.weather_screen.domain.model.WeatherDomainModel
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import com.example.myapp1.feature.wind_screen.ui.WindScreenActivity

class WeatherScreenActivity : AppCompatActivity()
{
    val weatherScreenViewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        weatherScreenViewModel.viewState.observe(this, Observer(::render))
         }

    @SuppressLint("StringFormatInvalid")
    private fun render(state: ViewState)
    {
        findViewById<TextView>(R.id.tvTemperature).text =
            getString(R.string.weather, state.weatherModel.temperature)
    }
}