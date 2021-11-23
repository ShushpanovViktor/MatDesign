package com.example.myapp1.feature.wind_screen.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapp1.R
import org.koin.android.viewmodel.ext.android.viewModel

class WindScreenActivity: AppCompatActivity() {

    val windScreenViewModel by viewModel<WindScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)
        windScreenViewModel.viewState.observe(this, Observer(::render))
           }

    @SuppressLint("StringFormatInvalid")
    private fun render(state: ViewState)
    {
        val speed = state.windDomainModel.speed.toString()
        findViewById<TextView>(R.id.tvWind).text = getString(R.string.wind_speed, speed)
    }
}
