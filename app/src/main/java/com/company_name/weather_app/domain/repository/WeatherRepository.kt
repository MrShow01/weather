package com.company_name.weather_app.domain.repository

import com.company_name.weather_app.domain.model.Weather


interface WeatherRepository {

    suspend fun getWeather(
        //add Cairo Lat and lng
        latitude: Double = CAIRO_LATITUDE,
        longitude: Double = CAIRO_LONGITUDE,
    ): Weather

    companion object {
        const val CAIRO_LATITUDE = 30.04448
        const val CAIRO_LONGITUDE = 31.2357
    }
}
