package com.example.myapp1

import androidx.lifecycle.ViewModel

class MainPresenter (): ViewModel()
{
    fun getTemperature(): String    {
        return "32"
    }

}