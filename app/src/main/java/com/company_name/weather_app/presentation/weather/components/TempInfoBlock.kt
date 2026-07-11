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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.company_name.weather_app.R
import com.company_name.weather_app.ui.theme.Black
import com.company_name.weather_app.ui.theme.White
import kotlin.math.roundToInt

@Composable
fun TempInfoBlock(
    min: Double,
    max: Double,
    condition: String,
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

                verticalArrangement = Arrangement.spacedBy(8.dp),

                ) {
                Text(
                    "Min", fontSize = 16.sp, color = Black

                )
                Text(
                    "${min.roundToInt()}°", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Black

                )
                Image(
                    painter = painterResource(id = R.drawable.arrow_down),
                    contentDescription = "Arrow Down",

                    modifier = Modifier.size(40.dp)
                )


            }
            VerticalDivider(
                modifier = Modifier.padding(horizontal = 8.dp),
                thickness = 1.dp,
                color = Black.copy(alpha = 0.1f)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {

                Text(
                    "Today", fontSize = 16.sp, color = Black

                )

                Text(
                    condition,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.widthIn(max = 180.dp),
                    color = Black

                )

            }
            VerticalDivider(
                modifier = Modifier.padding(horizontal = 8.dp),
                thickness = 1.dp,
                color = Black.copy(alpha = 0.1f)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

                verticalArrangement = Arrangement.spacedBy(8.dp),

                ) {
                Text(
                    "Max", fontSize = 16.sp, color = Black

                )
                Text(
                    "${max.roundToInt()}°", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Black

                )
                Image(
                    painter = painterResource(id = R.drawable.arrow_up),
                    contentDescription = "Arrow Up",
                    modifier = Modifier.size(40.dp)
                )


            }

        }

    }
}
