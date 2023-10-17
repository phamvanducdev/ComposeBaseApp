package com.ducpv.cba.core.domain.model

import com.ducpv.cba.core.common.StaticMethods
import com.ducpv.cba.core.common.StaticMethods.toDate
import com.ducpv.cba.core.data.network.dto.WeatherDTO
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Weather(
    val lastUpdated: String = "",
    val lastUpdatedEpoch: Int = 0,
    val tempC: Double = 0.0,
    val tempF: Double = 0.0,
    val feelsLikeC: Double = 0.0,
    val feelsLikeF: Double = 0.0,
    val condition: Condition = Condition(),
    val windMph: Double = 0.0,
    val windKph: Double = 0.0,
    val pressureMb: Double = 0.0,
    val pressureIn: Double = 0.0,
    val precipMm: Double = 0.0,
    val precipIn: Double = 0.0,
    val humidity: Int = 0,
    val cloud: Int = 0,
    val isDay: Int = 0,
    val uv: Double = 0.0,
    val gustMph: Double = 0.0,
    val gustKph: Double = 0.0,
    val airQuality: AirQuality = AirQuality(),
) {
    val updatedTime: Date
        get() = lastUpdated.toDate(StaticMethods.yyyy_MM_dd_HH_mm) ?: Date()
}

fun WeatherDTO.toWeather(): Weather {
    return Weather(
        lastUpdated = lastUpdated ?: "",
        lastUpdatedEpoch = lastUpdatedEpoch ?: 0,
        tempC = tempC ?: 0.0,
        tempF = tempF ?: 0.0,
        feelsLikeC = feelsLikeC ?: 0.0,
        feelsLikeF = feelsLikeF ?: 0.0,
        condition = condition?.toCondition() ?: Condition(),
        windMph = windMph ?: 0.0,
        windKph = windKph ?: 0.0,
        pressureMb = pressureMb ?: 0.0,
        pressureIn = pressureIn ?: 0.0,
        precipMm = precipMm ?: 0.0,
        precipIn = precipIn ?: 0.0,
        humidity = humidity ?: 0,
        cloud = cloud ?: 0,
        isDay = isDay ?: 0,
        uv = uv ?: 0.0,
        gustMph = gustMph ?: 0.0,
        gustKph = gustKph ?: 0.0,
        airQuality = airQuality?.toAirQuality() ?: AirQuality()
    )
}