package com.ducpv.cba.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by pvduc9773 on 25/09/2023.
 */
@Serializable
data class DayDTO(
    @SerialName("maxtemp_c") val maxTempC: Double? = null,
    @SerialName("maxtemp_f") val maxTempF: Double? = null,
    @SerialName("mintemp_c") val minTempC: Double? = null,
    @SerialName("mintemp_f") val minTempF: Double? = null,
    @SerialName("avgtemp_c") val avgTempC: Double? = null,
    @SerialName("avgtemp_f") val avgTempF: Double? = null,
    @SerialName("maxwind_mph") val maxWindMph: Double? = null,
    @SerialName("maxwind_kph") val maxWindKph: Double? = null,
    @SerialName("totalprecip_mm") val totalPrecipMm: Double? = null,
    @SerialName("totalprecip_in") val totalPrecipIn: Double? = null,
    @SerialName("avgvis_km") val avgVisKm: Double? = null,
    @SerialName("avgvis_miles") val avgVisMiles: Double? = null,
    @SerialName("avghumidity") val avgHumidity: Double? = null,
    @SerialName("condition") val condition: ConditionDTO? = null,
    @SerialName("daily_will_it_rain") val dailyWillItRain: Int? = null,
    @SerialName("daily_chance_of_rain") val dailyChanceOfRain: Int? = null,
    @SerialName("daily_will_it_snow") val dailyWillItSnow: Int? = null,
    @SerialName("daily_chance_of_snow") val dailyChanceOfSnow: Int? = null,
    @SerialName("uv") val uv: Double? = null,
)