package com.example.myapp1.feature.wind_screen.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapp1.R
import com.example.myapp1.feature.weather_screen.domain.model.WeatherDomainModel
import com.example.myapp1.feature.weather_screen.domain.model.WindDomainModel
import com.example.myapp1.feature.weather_screen.ui.WeatherScreenViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class WindScreenActivity: AppCompatActivity() {

    val windScreenViewModel by viewModel<WindScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)
        windScreenViewModel.livedata.observe(this, Observer(::render))
        windScreenViewModel.getWind()
        findViewById<Button>(R.id.buttonWind).setOnClickListener {
            Intent(this, WindScreenActivity::class.java).also { startActivity(it) }
        }
    }
    private fun render(model: WeatherDomainModel)
    {
        findViewById<TextView>(R.id.tvWind).text = model.speed
    }
}
