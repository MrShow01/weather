package com.company_name.weather_app.di

import com.company_name.weather_app.data.repository.WeatherRepositoryImpl
import com.company_name.weather_app.domain.repository.WeatherRepository


object RepositoryModule {
//Lazy Dependancy Injection
    val weatherRepository: WeatherRepository by lazy {
        WeatherRepositoryImpl(NetworkModule.weatherApiService)
    }
}
