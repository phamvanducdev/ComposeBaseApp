package com.ducpv.cba.core.data.network.retrofit

import com.ducpv.cba.core.data.network.dto.CurrentResponse
import com.ducpv.cba.core.data.network.dto.ForecastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    /**
     * @param aqi Get air quality data
     */
    @GET("v1/current.json")
    suspend fun getCurrent(
        @Query("q") q: String = "Hue",
        @Query("aqi") aqi: String = "yes",
    ): Response<CurrentResponse>

    /**
     * http://api.weatherapi.com/v1/forecast.json
     * @param days Number of days of weather forecast. Value ranges from 1 to 10
     * @param aqi Get air quality data
     * @param alerts Get weather alert data
     */
    @GET("v1/forecast.json")
    suspend fun getForecast(
        @Query("q") q: String = "Hue",
        @Query("days") days: Int = 1,
        @Query("aqi") aqi: String = "yes",
        @Query("alerts") alerts: String = "no",
    ): Response<ForecastResponse>
}