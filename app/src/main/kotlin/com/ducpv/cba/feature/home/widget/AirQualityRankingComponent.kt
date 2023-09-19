package com.ducpv.cba.feature.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ducpv.cba.R
import com.ducpv.cba.core.domain.model.Forecast
import com.ducpv.cba.ui.ComposeConstant
import com.ducpv.cba.ui.theme.AppColors
import com.ducpv.cba.ui.theme.AppTypography

@Composable
fun AirQualityRankingComponent(forecast: Forecast) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 24.dp)
            .background(
                brush = Brush.linearGradient(ComposeConstant.BackgroundGradientColor),
                shape = ComposeConstant.RoundedCornerShapeCircle,
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .padding(8.dp)
                    .background(
                        color = AppColors.White,
                        shape = ComposeConstant.RoundedCornerShapeCircle,
                    )
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chart_line_up),
                    tint = Color.Unspecified,
                    contentDescription = null,
                )
            }
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.city_air_quality_ranking),
                color = AppColors.White,
                style = AppTypography.titleMedium,
            )
            Text(
                text = "No.${forecast.ranking}",
                color = AppColors.White,
                style = AppTypography.titleMedium,
            )
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_arrow),
                tint = Color.Unspecified,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}