package com.company_name.weather_app.domain.model

//Object to be used in UI
data class Weather(
    val temperature: Double,
    val humidity: Int,
    val feelsLike: Double,
    val windSpeed: Double,
    val weatherCode: Int,
    val temperatureMax: Double,
    val temperatureMin: Double,
)
