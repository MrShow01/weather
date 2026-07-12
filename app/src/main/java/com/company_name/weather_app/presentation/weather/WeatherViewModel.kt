package com.company_name.weather_app.presentation.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company_name.weather_app.domain.repository.WeatherRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.log10

class WeatherViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val state: StateFlow<WeatherState> = _state.asStateFlow()

    private val _effect = Channel<WeatherEffect>()
    val effect = _effect.receiveAsFlow()


    fun onIntent(intent: WeatherIntent) {
        when (intent) {
            //When the user sends an action
            is WeatherIntent.LoadWeather -> loadWeather()
            is WeatherIntent.Refresh -> loadWeather()

        }
    }

    private fun loadWeather() {
        viewModelScope.launch {
                _state.update { it.copy(isLoading = true, error = null) }
            try {
                val weather = repository.getWeather()
                //Log.d("WEATHER", weather.toString())
                _state.update { it.copy(isLoading = false, weather = weather) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
                _effect.send(WeatherEffect.ShowError(e.message ?: "Something went wrong"))
            }
        }
    }
}