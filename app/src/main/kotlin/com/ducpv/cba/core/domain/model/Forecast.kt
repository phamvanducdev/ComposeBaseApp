package com.ducpv.cba.core.domain.model

import androidx.compose.ui.graphics.Color
import com.ducpv.cba.core.common.StaticMethods.isSameHour
import com.ducpv.cba.core.common.StaticMethods.toDate
import com.ducpv.cba.core.common.StaticMethods.yyyy_MM_dd
import com.ducpv.cba.core.common.StaticMethods.yyyy_MM_dd_HH_mm
import com.ducpv.cba.core.data.network.dto.ForecastDayDTO
import kotlinx.serialization.Serializable
import java.util.Date
import kotlin.random.Random

@Serializable
data class Forecast(
    val date: String = "",
    val dateEpoch: Int = 0,
    val day: Day = Day(),
    val hour: List<Hour> = emptyList(),
    val astro: Astro = Astro(),
    val aqi: Int = Random.nextInt(500),
    val ranking: Int = Random.nextInt(100)
) {
    enum class AirQualityType(val color: Color) {
        GOOD(Color(0xFF9CD84E)),
        MODERATE(Color(0xFFFACF39)),
        UNHEALTHY_FOR_SENSITIVE_GROUPS(Color(0xFFF99049)),
        UNHEALTHY(Color(0xFFF65E5F)),
        VERY_UNHEALTHY(Color(0xFFA070B6)),
        HAZARDOUS(Color(0xFFA06A7B)),
    }

    val dateTime: Date
        get() = date.toDate(yyyy_MM_dd) ?: Date()

    val airQualityType: AirQualityType
        get() = when (aqi) {
            in 0..50 -> AirQualityType.GOOD
            in 51..100 -> AirQualityType.MODERATE
            in 101..150 -> AirQualityType.UNHEALTHY_FOR_SENSITIVE_GROUPS
            in 151..200 -> AirQualityType.UNHEALTHY
            in 201..300 -> AirQualityType.VERY_UNHEALTHY
            else -> AirQualityType.HAZARDOUS
        }

    /**
     * Get short data (5 item) from Now
     */
    fun getRecentHours(size: Int): List<Hour> {
        val now = Date()
        val hours = hour.filter {
            val dateTime = it.time.toDate(yyyy_MM_dd_HH_mm) ?: now
            dateTime.isSameHour(now) || dateTime.after(now)
        }
        return when {
            hours.size >= size -> hours.subList(0, size)
            hour.size >= size -> hour.subList(0, size)
            else -> hour
        }
    }
}

fun ForecastDayDTO.toForecast(): Forecast {
    return Forecast(
        date = date ?: "",
        dateEpoch = dateEpoch ?: 0,
        day = day?.toDay() ?: Day(),
        hour = hour?.map { it.toHour() } ?: emptyList(),
        astro = astro?.toAstro() ?: Astro(),
    )
}