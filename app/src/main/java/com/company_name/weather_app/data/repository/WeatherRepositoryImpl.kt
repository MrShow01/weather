package com.company_name.weather_app.data.repository

import com.company_name.weather_app.data.mapper.toDomain
import com.company_name.weather_app.data.remote.api.WeatherApiService
import com.company_name.weather_app.domain.model.Weather
import com.company_name.weather_app.domain.repository.WeatherRepository


class WeatherRepositoryImpl(
    private val api: WeatherApiService,
) : WeatherRepository {
//suspend -> Async without intrupt app
    override suspend fun getWeather(latitude: Double, longitude: Double): Weather =
        api.getForecast(latitude = latitude, longitude = longitude).toDomain()
}
