package com.ducpv.cba.core.domain.repository

import com.ducpv.cba.core.data.network.ApiResponse
import com.ducpv.cba.core.data.network.WeatherDataSource
import com.ducpv.cba.core.domain.model.Current
import com.ducpv.cba.core.domain.model.Forecast
import javax.inject.Inject
import javax.inject.Singleton

interface WeatherRepository {
    suspend fun getCurrent(query: String): ApiResponse<Current>
    suspend fun getForecast(query: String, days: Int): ApiResponse<List<Forecast>>
}

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val networkDataSource: WeatherDataSource,
) : WeatherRepository {
    override suspend fun getCurrent(query: String): ApiResponse<Current> {
        return networkDataSource.getCurrent(query)
    }

    override suspend fun getForecast(query: String, days: Int): ApiResponse<List<Forecast>> {
        return networkDataSource.getForecast(query, days)
    }
}

