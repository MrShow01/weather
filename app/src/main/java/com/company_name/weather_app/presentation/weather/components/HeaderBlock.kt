package com.company_name.weather_app.presentation.weather.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.company_name.weather_app.R
import com.company_name.weather_app.presentation.weather.WeatherIntent
import com.company_name.weather_app.presentation.weather.WeatherViewModel
import com.company_name.weather_app.ui.theme.White

@Composable
fun HeaderBlock(viewModel: WeatherViewModel) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {

            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Menu",
                tint = White,

                modifier = Modifier.size(35.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 10.dp)

            ) {
                Text(
                    "Cairo, Egypt", color = White, fontWeight = FontWeight.W700, fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(8.dp))

                DayGetter()
            }
            Icon(
                painter = painterResource(id = R.drawable.refresh),
                contentDescription = "Refresh",
                tint = White,
                modifier = Modifier.size(35.dp).clickable(){
                    viewModel.onIntent(WeatherIntent.Refresh)
                }
            )

        }
    }
}
