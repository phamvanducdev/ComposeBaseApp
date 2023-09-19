package com.ducpv.cba.feature.home.widget

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ducpv.cba.R
import com.ducpv.cba.feature.home.CurrentWeather
import com.ducpv.cba.ui.ComposeConstant.RoundedCornerShape24dp
import com.ducpv.cba.ui.theme.AppColors
import com.ducpv.cba.ui.theme.AppTypography
import kotlin.math.roundToInt

@Composable
fun AirQualityComponent(currentWeather: CurrentWeather) {
    Box(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .background(
                color = AppColors.White,
                shape = RoundedCornerShape24dp,
            )
            .clip(shape = RoundedCornerShape24dp),
    ) {
        Column(
            modifier = Modifier.padding(vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = stringResource(id = R.string.air_quality),
                    color = AppColors.Black,
                    style = AppTypography.titleLarge,
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_refresh),
                    tint = Color.Unspecified,
                    contentDescription = null,
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                ItemAirQualityComponent(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_wind,
                    title = stringResource(R.string.wind),
                    value = "${currentWeather.windSpeed.roundToInt()}km/h",
                )
                ItemAirQualityComponent(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_drop,
                    title = stringResource(R.string.s02),
                    value = "${currentWeather.airQuality.so2}",
                )
                ItemAirQualityComponent(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_cloud_rain,
                    title = stringResource(R.string.rain),
                    value = "${currentWeather.rainChance.roundToInt()}%",
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                ItemAirQualityComponent(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_sunhorizon,
                    title = stringResource(R.string.uv),
                    value = "${currentWeather.uvIndex.roundToInt()}",
                )
                ItemAirQualityComponent(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_thermometer,
                    title = stringResource(R.string.temperature),
                    value = "${currentWeather.tempC.roundToInt()}",
                )
                ItemAirQualityComponent(
                    modifier = Modifier.weight(1f),
                    icon = R.drawable.ic_sunhorizon,
                    title = stringResource(R.string.ozone),
                    value = "${currentWeather.airQuality.o3.roundToInt()}",
                )
            }
        }
    }
}

@Composable
fun ItemAirQualityComponent(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int = -1,
    title: String = "",
    value: String = "",
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = icon),
            tint = Color.Unspecified,
            contentDescription = null,
        )
        Text(
            text = title,
            color = Color(0xFFCDD2DE),
            style = AppTypography.labelSmall.copy(fontSize = 16.sp),
            textAlign = TextAlign.Center,
            maxLines = 1,
        )
        Text(
            text = value,
            color = AppColors.Black,
            style = AppTypography.labelSmall.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
            ),
        )
    }
}