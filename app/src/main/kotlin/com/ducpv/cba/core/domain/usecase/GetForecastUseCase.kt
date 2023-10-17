package com.ducpv.cba.core.domain.usecase

import com.ducpv.cba.core.common.StaticMethods
import com.ducpv.cba.core.common.StaticMethods.addDays
import com.ducpv.cba.core.common.StaticMethods.format
import com.ducpv.cba.core.common.StaticMethods.isSameDate
import com.ducpv.cba.core.data.datastore.PrefsDataSource
import com.ducpv.cba.core.data.network.ApiResponse.Companion.body
import com.ducpv.cba.core.domain.model.Forecast
import com.ducpv.cba.core.domain.repository.WeatherRepository
import java.util.Date
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(
    private val prefsDataSource: PrefsDataSource,
    private val weatherRepository: WeatherRepository,
) {
    suspend fun execute(query: String, days: Int = 1): List<Forecast> {
        val forecastHistory = prefsDataSource.getForecastHistory()
        val forecastToday = weatherRepository.getForecast(query, days).body().orEmpty()
        if (forecastHistory.isEmpty() || !forecastHistory.last().dateTime.isSameDate(Date())) {
            saveForecastHistory(forecastToday.firstOrNull())
        }
        val forecastYesterday = forecastHistory.filter {
            !it.dateTime.isSameDate(Date())
        }.takeLast(1)
        if (forecastYesterday.isEmpty()) {
            val fakeForecastFuture = forecastToday.takeLast(1).map {
                it.copy(
                    date = it.dateTime.addDays(1).format(StaticMethods.yyyy_MM_dd).orEmpty()
                )
            }
            return forecastToday + fakeForecastFuture
        }
        return forecastYesterday + forecastToday
    }

    private suspend fun saveForecastHistory(forecast: Forecast?) {
        if (forecast == null) return
        prefsDataSource.setForecastHistory(forecast)
    }
}