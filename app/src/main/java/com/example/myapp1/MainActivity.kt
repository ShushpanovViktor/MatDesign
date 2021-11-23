package com.example.myapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.myapp1.feature.weather_screen.data.storage.SettingsRepo
import com.example.myapp1.feature.weather_screen.data.storage.SettingsRepoImpl
import com.example.myapp1.feature.weather_screen.ui.WeatherScreenActivity
import com.example.myapp1.feature.wind_screen.ui.WindScreenActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val presenter = MainPresenter()
    private val settingsRepo: SettingsRepo by inject()


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

        val cityChange = findViewById<ImageButton>(R.id.cityNew)
        val cityChangeT = findViewById<EditText>(R.id.cityChange)
        cityChange.setOnClickListener {
            GlobalScope.launch(Dispatchers.Default){
                settingsRepo.saveCity(cityChangeT.text.toString())}
            Toast.makeText(applicationContext, "City is set",Toast.LENGTH_SHORT).show()
                    }

        val buttonWind = findViewById<Button>(R.id.ButtonWind)
        buttonWind.setOnClickListener {

            Intent(this, WindScreenActivity::class.java).also { startActivity(it) }
        }


    }
}
