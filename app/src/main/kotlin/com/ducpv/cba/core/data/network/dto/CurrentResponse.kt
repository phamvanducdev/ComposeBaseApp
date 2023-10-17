package com.ducpv.cba.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by pvduc9773 on 24/09/2023.
 * Response http://api.weatherapi.com/v1/current.json?key=<API_KEY>&q=Hue&aqi=no
 */
@Serializable
data class CurrentResponse(
    @SerialName("current") val current: WeatherDTO? = null,
    @SerialName("location") val location: LocationDTO? = null,
)