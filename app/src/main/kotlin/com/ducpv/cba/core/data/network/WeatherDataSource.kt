package com.ducpv.cba.core.data.network

import com.ducpv.cba.core.data.network.dto.CurrentResponse
import com.ducpv.cba.core.data.network.dto.ForecastResponse
import com.ducpv.cba.core.data.network.dto.toForecastList
import com.ducpv.cba.core.data.network.retrofit.WeatherApi
import com.ducpv.cba.core.domain.model.Current
import com.ducpv.cba.core.domain.model.Forecast
import com.ducpv.cba.core.domain.model.toCurrentWeather
import javax.inject.Inject
import javax.inject.Singleton

interface WeatherDataSource {
    suspend fun getCurrent(query: String): ApiResponse<Current>
    suspend fun getForecast(query: String, days: Int = 1): ApiResponse<List<Forecast>>
}

@Singleton
class WeatherDataSourceImpl @Inject constructor(
    private val api: WeatherApi,
) : WeatherDataSource {
    override suspend fun getCurrent(query: String): ApiResponse<Current> {
        return ApiResponse.create(
            api.getCurrent(q = query),
            CurrentResponse::toCurrentWeather,
        )
    }

    override suspend fun getForecast(query: String, days: Int): ApiResponse<List<Forecast>> {
        return ApiResponse.create(
            api.getForecast(q = query, days = days),
            ForecastResponse::toForecastList,
        )
    }
}
