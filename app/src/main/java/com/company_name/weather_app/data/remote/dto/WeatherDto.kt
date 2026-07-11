package com.company_name.weather_app.data.remote.dto

import com.google.gson.annotations.SerializedName

//Convert the json to Model
data class WeatherResponseDto(
    @SerializedName("current") val current: CurrentDto,
    @SerializedName("daily") val daily: DailyDto,
)

data class CurrentDto(
    @SerializedName("temperature_2m") val temperature: Double,
    @SerializedName("relative_humidity_2m") val humidity: Int,
    @SerializedName("apparent_temperature") val apparentTemperature: Double,
    @SerializedName("wind_speed_10m") val windSpeed: Double,
    @SerializedName("weather_code") val weatherCode: Int,
)

data class DailyDto(
    @SerializedName("temperature_2m_max") val temperatureMax: List<Double>,
    @SerializedName("temperature_2m_min") val temperatureMin: List<Double>,
)
