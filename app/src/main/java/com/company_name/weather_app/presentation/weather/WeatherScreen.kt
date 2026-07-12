package com.company_name.weather_app.presentation.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.company_name.weather_app.presentation.weather.components.HeaderBlock
import com.company_name.weather_app.presentation.weather.components.RefreshButton
import com.company_name.weather_app.presentation.weather.components.TempInfoBlock
import com.company_name.weather_app.presentation.weather.components.TemperatureBlock
import com.company_name.weather_app.presentation.weather.components.WeatherInfoBlock
import com.company_name.weather_app.presentation.weather.components.weatherCodeToIcon
import com.company_name.weather_app.presentation.weather.components.weatherCodeToLabel
import com.company_name.weather_app.ui.theme.BackgroundGradientPrimary
import com.company_name.weather_app.ui.theme.BackgroundGradientSecondary
import com.company_name.weather_app.ui.theme.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val weather = state.weather
    val error = state.error
    val snackbarHostState = remember { SnackbarHostState() }
    val scrollState = rememberScrollState()
    // first load
    LaunchedEffect(Unit) {
        viewModel.onIntent(WeatherIntent.LoadWeather)
    }

    // show a snackbar whenever an error appears
    LaunchedEffect(error) {
        error?.let { snackbarHostState.showSnackbar(it) }
    }

    Scaffold(
        containerColor = Color.Transparent,
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            BackgroundGradientPrimary, BackgroundGradientSecondary
                        )
                    )
                )
                ,
            contentAlignment = Alignment.Center,
        ) {
            when {

                state.isLoading && weather == null -> {
                    CircularProgressIndicator(color = White)
                }

                weather != null -> {
                    val condition = weatherCodeToLabel(weather.weatherCode)
                    val iconRes = weatherCodeToIcon(weather.weatherCode)
                    PullToRefreshBox(
                        isRefreshing = state.isLoading,
                        onRefresh = { viewModel.onIntent(WeatherIntent.Refresh) },
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxSize()
                                .statusBarsPadding()
                                .navigationBarsPadding()
                                .verticalScroll(scrollState)
                                .padding(horizontal = 16.dp)
                        ) {
                            HeaderBlock(viewModel = viewModel)
                            Spacer(modifier = Modifier.height(40.dp))
                            TemperatureBlock(
                                temperature = weather.temperature,
                                condition = condition,
                                iconRes = iconRes,
                            )
                            Spacer(modifier = Modifier.height(24.dp))
                            WeatherInfoBlock(
                                humidity = weather.humidity,
                                windSpeed = weather.windSpeed,
                                feelsLike = weather.feelsLike,
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            TempInfoBlock(
                                min = weather.temperatureMin,
                                max = weather.temperatureMax,
                                condition = condition,
                            )
                            Spacer(modifier = Modifier.height(32.dp))
                            RefreshButton(
                                onClick = { viewModel.onIntent(WeatherIntent.Refresh) }
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }


                else -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier
                            .statusBarsPadding()
                            .navigationBarsPadding()
                            .padding(horizontal = 24.dp)
                    ) {
                        Text(
                            text = error ?: "Couldn't load weather.",
                            color = White,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                        )
                        RefreshButton(
                            onClick = { viewModel.onIntent(WeatherIntent.Refresh) }
                        )
                    }
                }
            }
        }
    }
}
