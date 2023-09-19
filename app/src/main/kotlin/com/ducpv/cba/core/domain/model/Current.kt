package com.ducpv.cba.core.domain.model

import com.ducpv.cba.core.data.network.dto.CurrentResponse
import kotlinx.serialization.Serializable

/**
 * Created by pvduc9773 on 24/09/2023.
 * Response http://api.weatherapi.com/v1/current.json?key=<API_KEY>&q=Hue&aqi=no
 */
@Serializable
data class Current(
    val current: Weather = Weather(),
    val location: Location = Location(),
)

fun CurrentResponse.toCurrentWeather(): Current {
    return Current(
        current = current?.toWeather() ?: Weather(),
        location = location?.toLocation() ?: Location(),
    )
}