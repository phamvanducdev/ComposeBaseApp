package com.ducpv.cba.core.domain.model

import com.ducpv.cba.core.common.StaticMethods.toDate
import com.ducpv.cba.core.common.StaticMethods.yyyy_MM_dd_HH_mm
import com.ducpv.cba.core.data.network.dto.HourDTO
import kotlinx.serialization.Serializable
import java.util.Date

/**
 * Created by pvduc9773 on 25/09/2023.
 */
@Serializable
data class Hour(
    val timeEpoch: Int = 0,
    val time: String = "",
    val tempC: Double = 0.0,
    val tempF: Double = 0.0,
    val condition: Condition = Condition(),
    val windMph: Double = 0.0,
    val windKph: Double = 0.0,
    val windDegree: Int = 0,
    val windDir: String = "",
    val pressureMb: Double = 0.0,
    val pressureIn: Double = 0.0,
    val precipMm: Double = 0.0,
    val precipIn: Double = 0.0,
    val humidity: Int = 0,
    val cloud: Int = 0,
    val feelsLikeC: Double = 0.0,
    val feelsLikeF: Double = 0.0,
    val windchillC: Double = 0.0,
    val windchillF: Double = 0.0,
    val heatIndexC: Double = 0.0,
    val heatIndexF: Double = 0.0,
    val dewPointC: Double = 0.0,
    val dewPointF: Double = 0.0,
    val willTtRain: Double = 0.0,
    val willItSnow: Double = 0.0,
    val isDay: Double = 0.0,
    val visKm: Double = 0.0,
    val visMiles: Double = 0.0,
) {
    val dateTime: Date get() = time.toDate(yyyy_MM_dd_HH_mm) ?: Date()
}

fun HourDTO.toHour(): Hour {
    return Hour(
        timeEpoch = timeEpoch ?: 0,
        time = time ?: "",
        tempC = tempC ?: 0.0,
        tempF = tempF ?: 0.0,
        condition = condition?.toCondition() ?: Condition(),
        windMph = windMph ?: 0.0,
        windKph = windKph ?: 0.0,
        windDegree = windDegree ?: 0,
        windDir = windDir ?: "",
        pressureMb = pressureMb ?: 0.0,
        pressureIn = pressureIn ?: 0.0,
        precipMm = precipMm ?: 0.0,
        precipIn = precipIn ?: 0.0,
        humidity = humidity ?: 0,
        cloud = cloud ?: 0,
        feelsLikeC = feelsLikeC ?: 0.0,
        feelsLikeF = feelsLikeF ?: 0.0,
        windchillC = windchillC ?: 0.0,
        windchillF = windchillF ?: 0.0,
        heatIndexC = heatIndexC ?: 0.0,
        heatIndexF = heatIndexF ?: 0.0,
        dewPointC = dewPointC ?: 0.0,
        dewPointF = dewPointF ?: 0.0,
        willTtRain = willTtRain ?: 0.0,
        willItSnow = willItSnow ?: 0.0,
        isDay = isDay ?: 0.0,
        visKm = visKm ?: 0.0,
        visMiles = visMiles ?: 0.0,
    )
}