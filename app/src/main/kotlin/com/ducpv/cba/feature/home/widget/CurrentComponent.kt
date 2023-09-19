package com.ducpv.cba.feature.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ducpv.cba.core.common.StaticMethods
import com.ducpv.cba.core.common.StaticMethods.format
import com.ducpv.cba.feature.home.CurrentWeather
import com.ducpv.cba.ui.ComposeConstant.BackgroundGradientColor
import com.ducpv.cba.ui.ComposeConstant.RoundedCornerShape24dp
import com.ducpv.cba.ui.theme.AppColors
import com.ducpv.cba.ui.theme.AppTypography
import kotlin.math.roundToInt

/**
 * Created by pvduc9773 on 01/10/2023.
 */
@Composable
fun CurrentComponent(current: CurrentWeather) {
    Box(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .padding(top = 72.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(BackgroundGradientColor),
                    shape = RoundedCornerShape24dp,
                )
                .clip(shape = RoundedCornerShape24dp),
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopEnd,
                ) {
                    Text(
                        modifier = Modifier.padding(
                            start = 24.dp,
                            top = 24.dp,
                            end = 24.dp,
                        ),
                        text = "${current.tempC.roundToInt()}°",
                        style = AppTypography.titleLarge.copy(
                            fontSize = 64.sp,
                            lineHeight = 64.em,
                            fontWeight = FontWeight.Bold,
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    AppColors.White,
                                    AppColors.Transparent,
                                ),
                            ),
                        )
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 24.dp, bottom = 24.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Text(
                            text = current.condition,
                            style = AppTypography.titleLarge.copy(fontSize = 24.sp),
                            color = AppColors.White,
                        )
                        Text(
                            text = current.updateTime.format(StaticMethods.EEEE_MM_dd) ?: "",
                            style = AppTypography.titleLarge.copy(
                                color = AppColors.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                            )
                        )
                    }
                    AsyncImage(
                        modifier = Modifier
                            .height(96.dp)
                            .padding(end = 12.dp, bottom = 12.dp),
                        model = current.iconURL,
                        colorFilter = ColorFilter.tint(AppColors.White.copy(alpha = 0.25f)),
                        contentDescription = null,
                    )
                }
            }
        }
        Icon(
            modifier = Modifier
                .padding(start = 24.dp, top = 24.dp)
                .size(148.dp),
            painter = painterResource(id = current.iconRes),
            tint = Color.Unspecified,
            contentDescription = null,
        )
    }
}