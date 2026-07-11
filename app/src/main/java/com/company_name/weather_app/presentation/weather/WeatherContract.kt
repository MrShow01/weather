package com.company_name.weather_app.presentation.weather

import com.company_name.weather_app.domain.model.Weather


data class WeatherState(
    val isLoading: Boolean = false,
    val weather: Weather? = null,
    val error: String? = null
)


sealed interface WeatherIntent {
    data object LoadWeather : WeatherIntent
    data object Refresh : WeatherIntent
}


sealed interface WeatherEffect {
    data class ShowError(val message: String) : WeatherEffect
}