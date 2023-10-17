package com.ducpv.cba.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by pvduc9773 on 24/09/2023.
 */
@Serializable
data class ForecastDTO(
    @SerialName("forecastday") val forecastDay: List<ForecastDayDTO>? = null,
)