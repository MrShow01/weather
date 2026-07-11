package com.company_name.weather_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.company_name.weather_app.presentation.weather.WeatherScreen
import com.company_name.weather_app.presentation.weather.WeatherViewModel
import com.company_name.weather_app.presentation.weather.WeatherViewModelFactory
import com.company_name.weather_app.ui.theme.Weather_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Weather_appTheme {
                val viewModel: WeatherViewModel = viewModel(factory = WeatherViewModelFactory())
                WeatherScreen(viewModel = viewModel)
            }
        }
    }
}
