package com.ducpv.cba.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ducpv.cba.ui.theme.AppColors

/**
 * Created by pvduc9773 on 01/10/2023.
 */
object ComposeConstant {
    val RoundedCornerShapeCircle = RoundedCornerShape(50)
    val RoundedCornerShape24dp = RoundedCornerShape(24.dp)

    val HomeBackgroundGradientColor = listOf(
        Color(0xFFE7FEFA),
        Color(0xFFDDF9FF),
        Color(0xFFFEFFDB),
    )
    val BackgroundGradientColor = listOf(
        Color(0xFF67E1D2),
        Color(0xFF54A8FF),
    )
    val ItemBackgroundTransparentColor = listOf(
        AppColors.Transparent,
        AppColors.Transparent,
    )
}