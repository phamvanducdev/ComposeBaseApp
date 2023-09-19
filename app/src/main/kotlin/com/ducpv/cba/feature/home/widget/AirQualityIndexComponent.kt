package com.ducpv.cba.feature.home.widget

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ducpv.cba.R
import com.ducpv.cba.core.domain.model.Forecast
import com.ducpv.cba.ui.ComposeConstant
import com.ducpv.cba.ui.theme.AppColors
import com.ducpv.cba.ui.theme.AppTypography

@Composable
@Preview(showBackground = true)
fun previewAirQualityIndexComponent() {
    AirQualityIndexComponent(
        forecast = Forecast(aqi = 450)
    )
}

@Composable
fun AirQualityIndexComponent(
    forecast: Forecast
) {
    val stroke = 24.dp
    val sweepAngle = 240f
    val startAngle = 150f

    val animatedAngle by animateFloatAsState(
        targetValue = (forecast.aqi.toFloat() / 500f) * sweepAngle,
        label = "animatedAngle"
    )

    Box(
        contentAlignment = Alignment.BottomCenter,
    ) {
        Column(
            modifier = Modifier.padding(42.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.aqi),
                color = Color(0xFF5AA6F0),
                style = AppTypography.labelLarge,
            )
            Text(
                text = forecast.aqi.toString(),
                color = AppColors.Black,
                style = AppTypography.headlineSmall,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 32.dp,
                    horizontal = 36.dp,
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                modifier = Modifier.width(100.dp),
                text = "0",
                color = Color(0xFFCDD2DE),
                style = AppTypography.bodyLarge,
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier.width(100.dp),
                text = "500",
                color = Color(0xFFCDD2DE),
                style = AppTypography.bodyLarge,
                textAlign = TextAlign.Center,
            )
        }
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 64.dp,
                    top = 64.dp,
                    end = 64.dp,
                )
                .aspectRatio(1f),
        ) {
            drawArc(
                color = Color(0xFFEAF3F5),
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(
                    width = stroke.toPx(),
                    cap = StrokeCap.Round,
                ),
                size = size,
            )
            drawArc(
                brush = Brush.linearGradient(ComposeConstant.BackgroundGradientColor),
                startAngle = startAngle,
                sweepAngle = animatedAngle,
                useCenter = false,
                style = Stroke(
                    width = stroke.toPx(),
                    cap = StrokeCap.Round,
                ),
                size = size,
            )
            drawArc(
                color = Color(0x5267E1D2),
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(
                    width = 2.dp.toPx(),
                    pathEffect = PathEffect.dashPathEffect(intervals = floatArrayOf(16f, 16f)),
                ),
                size = Size(
                    width = size.width - 56.dp.toPx(),
                    height = size.height - 56.dp.toPx(),
                ),
                topLeft = Offset(28.dp.toPx(), 28.dp.toPx())
            )
            drawArc(
                brush = Brush.linearGradient(ComposeConstant.BackgroundGradientColor),
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = 2.dp.toPx()),
                size = Size(
                    width = 16.dp.toPx(),
                    height = 16.dp.toPx(),
                ),
                topLeft = center + Offset(-8.dp.toPx(), -8.dp.toPx()),
            )
            rotate(animatedAngle + (startAngle - 90f), center) {
                drawLine(
                    brush = Brush.linearGradient(ComposeConstant.BackgroundGradientColor),
                    start = center - Offset(0f, -8.dp.toPx()),
                    end = center + Offset(0f, 64.dp.toPx()),
                    strokeWidth = 2.dp.toPx(),
                    cap = StrokeCap.Round,
                )
                drawLine(
                    brush = Brush.linearGradient(ComposeConstant.BackgroundGradientColor),
                    start = center + Offset(0f, -8.dp.toPx()),
                    end = center - Offset(0f, 24.dp.toPx()),
                    strokeWidth = 2.dp.toPx(),
                    cap = StrokeCap.Round,
                )
            }
        }
    }
}