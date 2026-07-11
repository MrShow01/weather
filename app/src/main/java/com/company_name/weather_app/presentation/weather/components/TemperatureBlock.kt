package com.company_name.weather_app.presentation.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.company_name.weather_app.ui.theme.White
import kotlin.math.roundToInt

@Composable
fun TemperatureBlock(
    temperature: Double,
    condition: String,
    iconRes: Int,
) {
    Image(
        painter = painterResource(id = iconRes), contentDescription = condition,

        modifier = Modifier.size(150.dp)
    )

    Text(
        "${temperature.roundToInt()}°", fontSize = 95.sp, fontWeight = FontWeight.Bold, color = White

    )
    Text(
        condition, fontSize = 28.sp, color = White

    )
}
