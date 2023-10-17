package com.ducpv.cba.feature.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ducpv.cba.R
import com.ducpv.cba.ui.ComposeConstant
import com.ducpv.cba.ui.theme.AppColors

/**
 * Created by pvduc9773 on 01/10/2023.
 */
@Composable
fun ToolbarComponent(
    themeState: Boolean,
    updateThemeState: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 24.dp,
                top = 24.dp,
                end = 24.dp,
                bottom = 12.dp,
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .shadow(
                    elevation = 24.dp,
                    shape = ComposeConstant.RoundedCornerShapeCircle,
                )
                .background(
                    color = AppColors.White,
                    shape = ComposeConstant.RoundedCornerShapeCircle,
                )
                .clip(
                    shape = ComposeConstant.RoundedCornerShapeCircle,
                ),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                tint = Color.Unspecified,
                contentDescription = null,
            )
        }

        SwitchThemeComponent(
            themeState = themeState,
            action = updateThemeState,
        )
    }
}
