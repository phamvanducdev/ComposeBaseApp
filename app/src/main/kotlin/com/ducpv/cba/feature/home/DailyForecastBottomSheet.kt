package com.ducpv.cba.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ducpv.cba.core.domain.model.Forecast
import com.ducpv.cba.feature.home.widget.AirQualityIndexComponent
import com.ducpv.cba.feature.home.widget.AirQualityRankingComponent
import com.ducpv.cba.feature.home.widget.DailyForecastComponent
import com.ducpv.cba.ui.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyForecastBottomSheet(
    sheetState: SheetState,
    forecasts: List<Forecast>,
    indexSelected: Int,
    onDismissRequest: () -> Unit,
) {
    var selectedIndex by remember { mutableIntStateOf(indexSelected) }

    ModalBottomSheet(
        modifier = Modifier.fillMaxSize(),
        sheetState = sheetState,
        windowInsets = WindowInsets(top = 132.dp),
        scrimColor = AppColors.Transparent,
        containerColor = AppColors.Transparent,
        shape = RoundedCornerShape(0.dp),
        onDismissRequest = onDismissRequest,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(
                        color = AppColors.White,
                        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                    ),
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                ) {
                    item {
                        DailyForecastComponent(
                            dailyForecasts = forecasts,
                            todayDateTime = forecasts[selectedIndex].dateTime,
                            onClick = {
                                selectedIndex = forecasts.indexOf(it)
                            },
                        )
                    }
                    item {
                        AirQualityIndexComponent(
                            forecast = forecasts[selectedIndex]
                        )
                    }
                    item {
                        AirQualityRankingComponent(
                            forecast = forecasts[selectedIndex]
                        )
                    }
                }
            }
        }
    }
}