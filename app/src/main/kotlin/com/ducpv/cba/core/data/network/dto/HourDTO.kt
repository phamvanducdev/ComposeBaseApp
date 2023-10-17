package com.ducpv.cba.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by pvduc9773 on 25/09/2023.
 */
@Serializable
data class HourDTO(
    @SerialName("time_epoch") val timeEpoch: Int? = null,
    @SerialName("time") val time: String? = null,
    @SerialName("temp_c") val tempC: Double? = null,
    @SerialName("temp_f") val tempF: Double? = null,
    @SerialName("condition") val condition: ConditionDTO? = null,
    @SerialName("wind_mph") val windMph: Double? = null,
    @SerialName("wind_kph") val windKph: Double? = null,
    @SerialName("wind_degree") val windDegree: Int? = null,
    @SerialName("wind_dir") val windDir: String? = null,
    @SerialName("pressure_mb") val pressureMb: Double? = null,
    @SerialName("pressure_in") val pressureIn: Double? = null,
    @SerialName("precip_mm") val precipMm: Double? = null,
    @SerialName("precip_in") val precipIn: Double? = null,
    @SerialName("humidity") val humidity: Int? = null,
    @SerialName("cloud") val cloud: Int? = null,
    @SerialName("feelslike_c") val feelsLikeC: Double? = null,
    @SerialName("feelslike_f") val feelsLikeF: Double? = null,
    @SerialName("windchill_c") val windchillC: Double? = null,
    @SerialName("windchill_f") val windchillF: Double? = null,
    @SerialName("heatindex_c") val heatIndexC: Double? = null,
    @SerialName("heatindex_f") val heatIndexF: Double? = null,
    @SerialName("dewpoint_c") val dewPointC: Double? = null,
    @SerialName("dewpoint_f") val dewPointF: Double? = null,
    @SerialName("will_it_rain") val willTtRain: Double? = null,
    @SerialName("will_it_snow") val willItSnow: Double? = null,
    @SerialName("is_day") val isDay: Double? = null,
    @SerialName("vis_km") val visKm: Double? = null,
    @SerialName("vis_miles") val visMiles: Double? = null,
)