package com.company_name.weather_app.data.mapper

import com.company_name.weather_app.data.remote.dto.WeatherResponseDto
import com.company_name.weather_app.domain.model.Weather


 // convert model to UI Object
fun WeatherResponseDto.toDomain(): Weather = Weather(
    temperature = current.temperature,
    humidity = current.humidity,
    feelsLike = current.apparentTemperature,
    windSpeed = current.windSpeed,
    weatherCode = current.weatherCode,
    //get the first day only
    temperatureMax = daily.temperatureMax.firstOrNull() ?: current.temperature,
    temperatureMin = daily.temperatureMin.firstOrNull() ?: current.temperature,
)
