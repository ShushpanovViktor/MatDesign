package com.example.myapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.myapp1.feature.weather_screen.ui.WeatherScreenActivity
class MainActivity : AppCompatActivity() {
    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //   val text = "Привет"
        //  val textView = findViewById<TextView>(R.id.textView)
        //  textView.text = presenter.getTemperature()
        //  val list = listOf (1,2,3,4,5)
        //  val filteredList: List<Int>? = null
        //  Log.d("TAG", "$filteredList")
//filteredList?.let { list ->  textView.text = list.toString() }
        //}
        val weatherButton = findViewById<Button>(R.id.weatherButton)
        weatherButton.setOnClickListener {
            Intent(this, WeatherScreenActivity::class.java).also { startActivity(it) }
        }
        val weatherChange = findViewById<Button>(R.id.weatherChange)
        weatherButton.setOnClickListener {
            Intent(this, WeatherScreenActivity::class.java).also { startActivity(it) }
        }
    }
}
