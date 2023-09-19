package com.ducpv.cba.feature.home.widget

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ducpv.cba.ui.ComposeConstant.BackgroundGradientColor
import com.ducpv.cba.ui.theme.AppColors

@Composable
fun LoadingAnimation(
    indicatorSize: Dp = 64.dp,
    circleColors: List<Color> = BackgroundGradientColor,
    animationDuration: Int = 360,
) {

    val infiniteTransition = rememberInfiniteTransition(label = "rememberInfiniteTransition")

    val rotateAnimation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animationDuration,
                easing = LinearEasing,
            )
        ),
        label = "rotateAnimation",
    )

    CircularProgressIndicator(
        modifier = Modifier
            .size(size = indicatorSize)
            .rotate(degrees = rotateAnimation)
            .border(
                width = indicatorSize / 8,
                brush = Brush.sweepGradient(circleColors),
                shape = CircleShape,
            ),
        progress = 1f,
        strokeWidth = 1.dp,
        color = AppColors.Transparent, // Set background color
    )
}