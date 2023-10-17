package com.ducpv.cba.feature.home.widget

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ducpv.cba.R
import com.ducpv.cba.ui.ComposeConstant.RoundedCornerShapeCircle
import com.ducpv.cba.ui.theme.AppColors

@Composable
fun SwitchThemeComponent(
    themeState: Boolean,
    action: (Boolean) -> Unit = {}
) {
    val width = 96.dp
    val halfWidth = width / 2

    val animatedPaddingStart by animateDpAsState(
        targetValue = when (themeState) {
            true -> 0.dp
            else -> halfWidth
        },
        animationSpec = tween(
            durationMillis = 600,
            easing = FastOutSlowInEasing,
        ),
        label = "animatedPaddingStart",
    )

    val animatedPaddingEnd by animateDpAsState(
        targetValue = when (themeState) {
            true -> halfWidth
            else -> 0.dp
        },
        animationSpec = tween(
            durationMillis = 600,
            easing = FastOutSlowInEasing,
        ),
        label = "animatedPaddingEnd",
    )

    val animatedThumbnailColor by animateColorAsState(
        targetValue = Color(0x5E73E6FF),
        animationSpec = tween(
            durationMillis = 600,
            easing = FastOutSlowInEasing,
        ),
        label = "animatedThumbnailColor",
    )

    val animatedToggleColor by animateColorAsState(
        targetValue = AppColors.White,
        animationSpec = tween(
            durationMillis = 600,
            easing = FastOutSlowInEasing,
        ),
        label = "animatedToggleColor",
    )

    Column(
        modifier = Modifier.size(width, halfWidth),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = animatedThumbnailColor,
                    shape = RoundedCornerShapeCircle,
                )
                .clip(
                    shape = RoundedCornerShapeCircle,
                )
        ) {
            // thumbnail
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier.size(halfWidth),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_light),
                        tint = AppColors.White,
                        contentDescription = null
                    )
                }
                Box(
                    modifier = Modifier.size(halfWidth),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_night),
                        tint = AppColors.White,
                        contentDescription = null
                    )
                }
            }
            // toggle
            Box(
                modifier = Modifier
                    .padding(
                        start = animatedPaddingStart,
                        end = animatedPaddingEnd,
                    )
                    .fillMaxSize()
                    .shadow(
                        elevation = 24.dp,
                        shape = RoundedCornerShapeCircle,
                    )
                    .background(
                        color = animatedToggleColor,
                        shape = RoundedCornerShapeCircle,
                    )
                    .clip(
                        shape = RoundedCornerShapeCircle,
                    )
                    .clickable {
                        action.invoke(!themeState)
                    },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(
                        id = if (themeState) R.drawable.ic_light else R.drawable.ic_night
                    ),
                    tint = Color(0xFF5AB9F3),
                    contentDescription = null
                )
            }
        }
    }
}