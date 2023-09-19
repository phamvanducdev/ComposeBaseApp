package com.ducpv.cba.core.data.network.dto

import com.ducpv.cba.core.domain.model.Forecast
import com.ducpv.cba.core.domain.model.toForecast
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by pvduc9773 on 24/09/2023.
 * Response http://api.weatherapi.com/v1/forecast.json?key=<API_KEY>&q=Hue&days=1&aqi=no&alerts=no
 */
@Serializable
data class ForecastResponse(
    @SerialName("location") val location: LocationDTO? = null,
    @SerialName("current") val current: WeatherDTO? = null,
    @SerialName("forecast") val forecast: ForecastDTO? = null,
)

fun ForecastResponse.toForecastList(): List<Forecast> {
    return forecast?.forecastDay?.map { it.toForecast() } ?: emptyList()
}