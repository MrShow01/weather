package com.company_name.weather_app.data.remote.api

import com.company_name.weather_app.data.remote.dto.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 https://api.open-meteo.com/v1/forecast?
 latitude=..
 &longitude=..
 &current=temperature_2m,
 relative_humidity_2m,
 apparent_temperature,
 wind_speed_10m,weather_code
 &daily=temperature_2m_max
 ,temperature_2m_min
 &timezone=auto
 */
interface WeatherApiService {

    @GET("v1/forecast")
    suspend fun getForecast(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String = CURRENT_FIELDS,
        @Query("daily") daily: String = DAILY_FIELDS,
        @Query("timezone") timezone: String = "auto",
    ): WeatherResponseDto

    companion object {
        private const val CURRENT_FIELDS =
            "temperature_2m,relative_humidity_2m,apparent_temperature,wind_speed_10m,weather_code"
        private const val DAILY_FIELDS = "temperature_2m_max,temperature_2m_min"
    }
}
