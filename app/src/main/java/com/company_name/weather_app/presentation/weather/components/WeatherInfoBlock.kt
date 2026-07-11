package com.company_name.weather_app.presentation.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.company_name.weather_app.R
import com.company_name.weather_app.ui.theme.Black
import com.company_name.weather_app.ui.theme.White
import kotlin.math.roundToInt

@Composable
fun WeatherInfoBlock(
    humidity: Int,
    windSpeed: Double,
    feelsLike: Double,
) {
    Box(
        modifier = Modifier
            .background(
                White, shape = RoundedCornerShape(16.dp)
            )
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp, vertical = 16.dp
            )
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.humidity),
                    contentDescription = "Humidity",

                    modifier = Modifier.size(40.dp)
                )
                Text(
                    "Humidity", fontSize = 16.sp, color = Black

                )
                Text(
                    "$humidity%", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Black

                )

            }
            VerticalDivider(
                modifier = Modifier.padding(horizontal = 8.dp),
                thickness = 1.dp,
                color = Black.copy(alpha = 0.1f)
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.wind), contentDescription = "Wind",

                    modifier = Modifier.size(40.dp)
                )
                Text(
                    "Wind", fontSize = 16.sp, color = Black

                )
                Text(
                    "${windSpeed.roundToInt()}", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Black

                )
                Text(
                    "km/h", fontSize = 18.sp,

                    color = Black

                )

            }
            VerticalDivider(
                modifier = Modifier.padding(horizontal = 8.dp),
                thickness = 1.dp,
                color = Black.copy(alpha = 0.1f)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.temp),
                    contentDescription = "Feels Like",

                    modifier = Modifier.size(40.dp)
                )
                Text(
                    "Feels Like", fontSize = 16.sp, color = Black

                )
                Text(
                    "${feelsLike.roundToInt()}°", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Black

                )

            }

        }

    }
}
