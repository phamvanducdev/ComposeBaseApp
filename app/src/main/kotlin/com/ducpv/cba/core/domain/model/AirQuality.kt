package com.ducpv.cba.core.domain.model

import com.ducpv.cba.core.data.network.dto.AirQualityDTO
import kotlinx.serialization.Serializable

@Serializable
data class AirQuality(
    val co: Double = 0.0,
    val no2: Double = 0.0,
    val o3: Double = 0.0,
    val so2: Double = 0.0,
    val pm25: Double = 0.0,
    val pm10: Double = 0.0,
    val usEpaIndex: Double = 0.0,
    val gbDefraIndex: Double = 0.0,
)

fun AirQualityDTO.toAirQuality(): AirQuality {
    return AirQuality(
        co = co ?: 0.0,
        no2 = no2 ?: 0.0,
        o3 = o3 ?: 0.0,
        so2 = so2 ?: 0.0,
        pm25 = pm25 ?: 0.0,
        pm10 = pm10 ?: 0.0,
        usEpaIndex = usEpaIndex ?: 0.0,
        gbDefraIndex = gbDefraIndex ?: 0.0,
    )
}