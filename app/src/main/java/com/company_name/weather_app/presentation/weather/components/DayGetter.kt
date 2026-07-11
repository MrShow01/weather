package com.company_name.weather_app.presentation.weather.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.company_name.weather_app.ui.theme.White
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun DayGetter() {
    val formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM", Locale.ENGLISH)
    val today = LocalDate.now().format(formatter)
    Text(
        today, color = White, fontSize = 16.sp
    )
}
