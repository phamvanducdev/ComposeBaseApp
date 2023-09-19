package com.ducpv.cba.core.domain.model

import com.ducpv.cba.core.data.network.dto.DayDTO
import kotlinx.serialization.Serializable

@Serializable
data class Day(
    val maxTempC: Double = 0.0,
    val maxTempF: Double = 0.0,
    val minTempC: Double = 0.0,
    val minTempF: Double = 0.0,
    val avgTempC: Double = 0.0,
    val avgTempF: Double = 0.0,
    val maxWindMph: Double = 0.0,
    val maxWindKph: Double = 0.0,
    val totalPrecipMm: Double = 0.0,
    val totalPrecipIn: Double = 0.0,
    val avgVisKm: Double = 0.0,
    val avgVisMiles: Double = 0.0,
    val avgHumidity: Double = 0.0,
    val condition: Condition = Condition(),
    val dailyWillItRain: Int = 0,
    val dailyChanceOfRain: Int = 0,
    val dailyWillItSnow: Int = 0,
    val dailyChanceOfSnow: Int = 0,
    val uv: Double = 0.0,
)

fun DayDTO.toDay(): Day {
    return Day(
        maxTempC = maxTempC ?: 0.0,
        maxTempF = maxTempF ?: 0.0,
        minTempC = minTempC ?: 0.0,
        minTempF = minTempF ?: 0.0,
        avgTempC = avgTempC ?: 0.0,
        avgTempF = avgTempF ?: 0.0,
        maxWindMph = maxWindMph ?: 0.0,
        maxWindKph = maxWindKph ?: 0.0,
        totalPrecipMm = totalPrecipMm ?: 0.0,
        totalPrecipIn = totalPrecipIn ?: 0.0,
        avgVisKm = avgVisKm ?: 0.0,
        avgVisMiles = avgVisMiles ?: 0.0,
        avgHumidity = avgHumidity ?: 0.0,
        condition = condition?.toCondition() ?: Condition(),
        dailyWillItRain = dailyChanceOfRain ?: 0,
        dailyChanceOfRain = dailyChanceOfRain ?: 0,
        dailyWillItSnow = dailyChanceOfRain ?: 0,
        dailyChanceOfSnow = dailyChanceOfRain ?: 0,
        uv = uv ?: 0.0,
    )
}