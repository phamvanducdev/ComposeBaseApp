package com.ducpv.cba.feature.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ducpv.cba.core.common.StaticMethods.format
import com.ducpv.cba.core.common.StaticMethods.isSameDate
import com.ducpv.cba.core.domain.model.Forecast
import com.ducpv.cba.ui.ComposeConstant.BackgroundGradientColor
import com.ducpv.cba.ui.ComposeConstant.ItemBackgroundTransparentColor
import com.ducpv.cba.ui.ComposeConstant.RoundedCornerShapeCircle
import com.ducpv.cba.ui.theme.AppColors
import com.ducpv.cba.ui.theme.AppTypography
import java.util.Date

@Composable
fun DailyForecastComponent(
    dailyForecasts: List<Forecast>,
    todayDateTime: Date = Date(),
    onClick: (Forecast) -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        dailyForecasts.forEach { forecast ->
            ItemDailyForecastComponent(
                forecast = forecast,
                selected = forecast.dateTime.isSameDate(todayDateTime),
                onClick = onClick,
            )
        }
    }
}


@Composable
fun ItemDailyForecastComponent(
    forecast: Forecast,
    selected: Boolean,
    onClick: (Forecast) -> Unit,
) {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    if (selected) {
                        BackgroundGradientColor
                    } else {
                        ItemBackgroundTransparentColor
                    }
                ),
                shape = RoundedCornerShapeCircle,
            )
            .clip(shape = RoundedCornerShapeCircle)
            .clickable { onClick(forecast) },
    ) {
        Column(
            modifier = Modifier
                .padding(
                    vertical = 24.dp,
                    horizontal = 12.dp,
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = forecast.dateTime.format("EEE").toString(),
                color = if (selected) {
                    AppColors.White
                } else {
                    AppColors.Black
                },
                style = AppTypography.bodyMedium.copy(fontSize = 16.sp),
            )
            Text(
                text = forecast.dateTime.format("MM/dd").toString(),
                color = if (selected) {
                    Color(0xFFD0F3FF)
                } else {
                    Color(0xFFA0A7BA)
                },
                style = AppTypography.bodyMedium.copy(fontSize = 12.sp),
            )
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                modifier = Modifier.size(42.dp),
                model = forecast.day.condition.iconURL,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${forecast.day.avgTempC}°",
                color = if (selected) {
                    AppColors.White
                } else {
                    AppColors.Black
                },
                style = AppTypography.titleMedium.copy(fontSize = 18.sp),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = forecast.aqi.toString(),
                color = AppColors.White,
                style = AppTypography.bodySmall.copy(fontSize = 12.sp),
                modifier = Modifier
                    .background(
                        color = forecast.airQualityType.color,
                        shape = RoundedCornerShape(4.dp),
                    )
                    .padding(
                        vertical = 2.dp,
                        horizontal = 4.dp,
                    )
            )
        }
    }
}