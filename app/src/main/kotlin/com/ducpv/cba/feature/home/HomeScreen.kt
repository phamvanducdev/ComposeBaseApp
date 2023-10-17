package com.ducpv.cba.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ducpv.cba.core.domain.model.Forecast
import com.ducpv.cba.feature.home.widget.AirQualityComponent
import com.ducpv.cba.feature.home.widget.CurrentComponent
import com.ducpv.cba.feature.home.widget.DailyForecastComponent
import com.ducpv.cba.feature.home.widget.LoadingAnimation
import com.ducpv.cba.feature.home.widget.ToolbarComponent
import com.ducpv.cba.navigation.AppState
import com.ducpv.cba.ui.ComposeConstant.HomeBackgroundGradientColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    appState: AppState,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    data class ShowBottomSheetState(
        val isShow: Boolean = false,
        val forecasts: List<Forecast> = emptyList(),
        val indexSelected: Int = 1,
    )

    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var showBottomSheetState by remember { mutableStateOf(ShowBottomSheetState()) }
    val themeState: Boolean by viewModel.themeState.collectAsStateWithLifecycle()
    val progressState: Boolean by viewModel.progressState.collectAsStateWithLifecycle()
    val current: CurrentWeather by viewModel.currentState.collectAsStateWithLifecycle()
    val dailyForecasts: List<Forecast> by viewModel.dailyForecastsState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(HomeBackgroundGradientColor)),
    ) {
        Scaffold(containerColor = Color.Transparent) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = innerPadding.calculateTopPadding())
            ) {
                Column {
                    ToolbarComponent(themeState, viewModel::updateThemeState)
                    if (progressState) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center,
                        ) {
                            LoadingAnimation()
                        }
                    } else {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState()),
                        ) {
                            CurrentComponent(current)
                            AirQualityComponent(current)
                            DailyForecastComponent(dailyForecasts) {
                                showBottomSheetState = ShowBottomSheetState(
                                    isShow = true,
                                    forecasts = dailyForecasts,
                                    indexSelected = dailyForecasts.indexOf(it)
                                )
                            }
                            Spacer(modifier = Modifier.height(24.dp))
                        }
                    }
                }
            }
            if (showBottomSheetState.isShow) {
                DailyForecastBottomSheet(
                    sheetState = bottomSheetState,
                    forecasts = showBottomSheetState.forecasts,
                    indexSelected = showBottomSheetState.indexSelected,
                    onDismissRequest = {
                        showBottomSheetState = ShowBottomSheetState()
                    }
                )
            }
        }
    }
}