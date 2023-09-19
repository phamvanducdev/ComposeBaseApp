package com.ducpv.cba.core.domain.model

import com.ducpv.cba.R
import com.ducpv.cba.core.common.StaticMethods.isNight
import com.ducpv.cba.core.data.network.dto.ConditionDTO
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Condition(
    val text: String = "",
    val icon: String = "",
    val code: Int = 0,
) {
    val iconURL: String get() = "http:$icon"

    /**
     * Sunny
     * Partly Cloudy
     * Cloudy
     * Overcast
     * Mist
     * Patchy rain nearby
     * Patchy snow nearby
     * Patchy sleet nearby
     * Patchy freezing drizzle nearby
     * Thundery outbreaks in nearby
     * Blowing snow
     * Blizzard
     * Fog
     * Freezing fog
     * Patchy light drizzle
     * Light drizzle
     * Freezing drizzle
     * Heavy freezing drizzle
     * Patchy light rain
     * Light rain
     * Moderate rain at times
     * Moderate rain
     * Heavy rain at times
     * Heavy rain
     * Light freezing rain
     * Moderate or heavy freezing rain
     * Light sleet
     * Moderate or heavy sleet
     * Patchy light snow
     * Light snow
     * Patchy moderate snow
     * Moderate snow
     * Patchy heavy snow
     * Heavy snow
     * Ice pellets
     * Light rain shower
     * Moderate or heavy rain shower
     * Torrential rain shower
     * Light sleet showers
     * Moderate or heavy sleet showers
     * Light snow showers
     * Moderate or heavy snow showers
     * Light showers of ice pellets
     * Moderate or heavy showers of ice pellets
     * Patchy light rain in area with thunder
     * Moderate or heavy rain in area with thunder
     * Patchy light snow in area with thunder
     * Moderate or heavy snow in area with thunder
     */
    val iconRes: Int
        get() = when {
            text.lowercase().contains("cloudy") -> {
                if (Date().isNight()) {
                    R.drawable.ic_moon_clouds
                } else {
                    R.drawable.ic_sun_clouds
                }
            }

            text.lowercase().contains("rain") -> {
                if (Date().isNight()) {
                    R.drawable.ic_moon_rain
                } else {
                    R.drawable.ic_sun_rain
                }
            }

            text.lowercase().contains("thunder") -> {
                if (Date().isNight()) {
                    R.drawable.ic_thunder_night
                } else {
                    R.drawable.ic_thunder
                }
            }

            else -> {
                if (Date().isNight()) {
                    R.drawable.ic_moon
                } else {
                    R.drawable.ic_sun
                }
            }
        }
}

fun ConditionDTO.toCondition(): Condition {
    return Condition(
        text = text ?: "",
        icon = icon ?: "",
        code = code ?: 0,
    )
}