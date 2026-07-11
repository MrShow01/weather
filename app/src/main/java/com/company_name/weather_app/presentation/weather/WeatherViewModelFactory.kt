package com.company_name.weather_app.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.company_name.weather_app.di.RepositoryModule
import com.company_name.weather_app.domain.repository.WeatherRepository


class WeatherViewModelFactory(
    private val repository: WeatherRepository = RepositoryModule.weatherRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            "Unknown ViewModel class: ${modelClass.name}"
        }
        @Suppress("UNCHECKED_CAST")
        return WeatherViewModel(repository) as T
    }
}
