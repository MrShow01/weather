Weather App 
A modern Android Weather Application built with Kotlin,
Jetpack Compose, and MVI (Model-View-Intent) architecture.
The project follows Clean Architecture principles with clear separation between Presentation,
Domain, and Data layers.

Features
Fetch current weather data from a remote API
Display temperature and weather conditions
Pull-to-refresh / manual refresh support
Error handling with one-time UI effects
Reactive UI using StateFlow
Dependency Injection
Clean and scalable architecture

Architecture Overview

This project follows:

MVI (Model-View-Intent)
Clean Architecture
Repository Pattern
Dependency Injection
Jetpack Compose
┌───────────────┐
│     View      │
│ WeatherScreen │
└───────┬───────┘
│ Intent
▼
┌───────────────┐
│   ViewModel   │
│ WeatherVM     │
└───────┬───────┘
│
│ Calls
▼
┌───────────────┐
│ Repository    │
│ Interface     │
└───────┬───────┘
│
▼
┌───────────────┐
│ RepositoryImpl│
└───────┬───────┘
│
▼
┌───────────────┐
│ Weather API   │
└───────┬───────┘
│
▼
┌───────────────┐
│ Weather DTO   │
└───────┬───────┘
│ Mapper
▼
┌───────────────┐
│ Domain Model  │
│   Weather     │
└───────────────┘
Project Structure
com.company_name.weather_app
│
├── data
│   ├── mapper
│   │   └── WeatherMapper.kt
│   │
│   ├── remote
│   │   ├── api
│   │   │   └── WeatherApiService.kt
│   │   │
│   │   └── dto
│   │       └── WeatherDto.kt
│   │
│   └── repository
│       └── WeatherRepositoryImpl.kt
│
├── di
│   ├── NetworkModule.kt
│   └── RepositoryModule.kt
│
├── domain
│   ├── model
│   │   └── Weather.kt
│   │
│   └── repository
│       └── WeatherRepository.kt
│
├── presentation
│   └── weather
│       ├── components
│       ├── WeatherContract.kt
│       ├── WeatherScreen.kt
│       ├── WeatherViewModel.kt
│       └── WeatherViewModelFactory.kt
│
└── ui.theme

MVI Data Flow

User Clicks Refresh
│
▼
WeatherIntent.Refresh
│
▼
WeatherViewModel
│
▼
WeatherRepository
│
▼
WeatherApiService
│
▼
WeatherDto
│
▼
WeatherMapper
│
▼
Weather
│
▼
WeatherState Updated
│
▼
Compose Recomposition
