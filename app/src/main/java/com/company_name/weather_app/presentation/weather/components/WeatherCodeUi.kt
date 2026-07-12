package com.company_name.weather_app.presentation.weather.components

import androidx.annotation.DrawableRes
import com.company_name.weather_app.R

//Map every code to i'ts name
fun weatherCodeToLabel(code: Int): String = when (code) {
    0 -> "Clear sky"
    1 -> "Mainly clear"
    2 -> "Partly cloudy"
    3 -> "Overcast"
    45, 48 -> "Fog"
    51, 53, 55 -> "Drizzle"
    56, 57 -> "Freezing drizzle"
    61, 63, 65 -> "Rain"
    66, 67 -> "Freezing rain"
    71, 73, 75 -> "Snow"
    77 -> "Snow grains"
    80, 81, 82 -> "Rain showers"
    85, 86 -> "Snow showers"
    95 -> "Thunderstorm"
    96, 99 -> "Thunderstorm with hail"
    else -> "Unknown"
}

// 0-> sun 2 ->partly cloudy 3 - > cloudy 61,63 , 65 -> rain 95,96 ,99 -> thunderstorm
@DrawableRes
fun weatherCodeToIcon(code: Int): Int = when (code) {
    0, 1 -> R.drawable.sun
    2 -> R.drawable.partly_cloudy
    3 -> R.drawable.cloud
    61, 63, 65 -> R.drawable.rain
    95, 96, 99 -> R.drawable.thunderstorm
    else -> R.drawable.cloud
}
