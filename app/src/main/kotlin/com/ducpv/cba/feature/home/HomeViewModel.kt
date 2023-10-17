package com.ducpv.cba.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ducpv.cba.core.domain.model.AirQuality
import com.ducpv.cba.core.domain.model.Forecast
import com.ducpv.cba.core.domain.usecase.GetCurrentUseCase
import com.ducpv.cba.core.domain.usecase.GetForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCurrentUseCase: GetCurrentUseCase,
    private val getForecastUseCase: GetForecastUseCase,
) : ViewModel() {
    private var queryLocationName: String = "Ho Chi Minh"

    private var _themeState = MutableStateFlow(true)
    val themeState = _themeState.asStateFlow()

    private var _progressState = MutableStateFlow(true)
    val progressState = _progressState.asStateFlow()

    private var _currentState = MutableStateFlow(CurrentWeather())
    val currentState = _currentState.asStateFlow()

    private var _dailyForecastsState = MutableStateFlow<List<Forecast>>(emptyList())
    val dailyForecastsState = _dailyForecastsState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _progressState.value = true
                val current = getCurrentUseCase.execute(queryLocationName) ?: return@launch
                val forecasts = getForecastUseCase.execute(queryLocationName, 3)
                val forecastToday = forecasts.firstOrNull() ?: return@launch
                _currentState.value = CurrentWeather(
                    tempC = current.current.tempC,
                    condition = current.current.condition.text,
                    iconURL = forecastToday.day.condition.iconURL,
                    iconRes = forecastToday.day.condition.iconRes,
                    nameLocation = current.location.name,
                    windSpeed = current.current.windKph,
                    rainChance = forecastToday.day.dailyChanceOfRain.toDouble(),
                    pressure = current.current.pressureMb,
                    uvIndex = current.current.uv,
                    updateTime = current.current.updatedTime,
                    airQuality = current.current.airQuality,
                )
                _dailyForecastsState.value = forecasts
                _progressState.value = false
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    fun updateThemeState(state: Boolean) {
        _themeState.value = state
    }
}

data class CurrentWeather(
    val tempC: Double = 0.0,
    val condition: String = "",
    val nameLocation: String = "",
    val windSpeed: Double = 0.0,
    val rainChance: Double = 0.0,
    val pressure: Double = 0.0,
    val uvIndex: Double = 0.0,
    val windSpeedChanged: Double = 0.0,
    val rainChanceChanged: Double = 0.0,
    val pressureChanged: Double = 0.0,
    val uvIndexChanged: Double = 0.0,
    val updateTime: Date = Date(),
    val airQuality: AirQuality = AirQuality(),
    val iconURL: String = "",
    val iconRes: Int = -1,
)

data class HourlyForecast(
    val time: Date = Date(),
    val icon: String? = null,
    val tempC: Double = 0.0,
)