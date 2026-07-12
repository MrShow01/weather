# Weather App

A modern Android Weather Application built with Kotlin, Jetpack Compose, and MVI (Model-View-Intent) architecture. The project follows Clean Architecture principles with clear separation between Presentation, Domain, and Data layers.

## Features

- Fetch current weather data from a remote API
- Display temperature and weather conditions
- Pull-to-refresh / manual refresh support
- Error handling with one-time UI effects
- Reactive UI using StateFlow
- Dependency Injection with Hilt
- Clean and scalable architecture

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVI (Model-View-Intent) + Clean Architecture
- **Networking**: Retrofit 2 + OkHttp
- **Async**: Coroutines + StateFlow
- **Dependency Injection**: Hilt
- **Material Design**: Material 3
- **Minimum SDK**: 26 (Android 8.0)
- **Target SDK**: 36

## Architecture Overview

This project follows:

- **MVI (Model-View-Intent)**: Unidirectional data flow with explicit intents
- **Clean Architecture**: Separation of concerns across layers
- **Repository Pattern**: Abstraction for data sources
- **Dependency Injection**: Hilt for managing dependencies
- **Jetpack Compose**: Modern declarative UI framework

### Architecture Diagram

```
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
```

## Project Structure

```
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
```

## MVI Data Flow

```
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
```

## Getting Started

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or newer
- JDK 11 or higher
- Android SDK 36
- Minimum SDK 26 (Android 8.0)

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd weather_app
   ```

2. Open the project in Android Studio

3. Sync Gradle files

4. Add your API key in the appropriate configuration file (if required)

### Running the App

1. Connect an Android device or start an emulator
2. Click the Run button in Android Studio or use:
   ```bash
   ./gradlew installDebug
   ```

## Key Components

### Presentation Layer
- **WeatherScreen**: Compose UI screen that displays weather data
- **WeatherViewModel**: Manages UI state and handles user intents
- **WeatherContract**: Defines state, intents, and effects for the MVI pattern

### Domain Layer
- **Weather**: Domain model representing weather data
- **WeatherRepository**: Interface for weather data operations

### Data Layer
- **WeatherRepositoryImpl**: Implementation of the repository interface
- **WeatherApiService**: Retrofit API service for fetching weather data
- **WeatherDto**: Data transfer object for API responses
- **WeatherMapper**: Maps DTOs to domain models

## Dependencies

- Jetpack Compose BOM
- AndroidX Core KTX
- AndroidX Lifecycle
- Retrofit 2
- OkHttp Logging Interceptor
- Gson Converter
- Material 3


