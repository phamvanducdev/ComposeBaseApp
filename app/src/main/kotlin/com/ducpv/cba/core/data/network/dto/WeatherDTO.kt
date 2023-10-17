package com.ducpv.cba.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by pvduc9773 on 24/09/2023.
 * DTO (Data Transfer Object) matching expected JSON Weather Object from https://www.weatherapi.com/
 * @param lastUpdated Local time when the real time data was updated
 * @param lastUpdatedEpoch Local time when the real time data was updated in unix time
 * @param tempC Temperature in celsius
 * @param tempF Temperature in fahrenheit
 * @param feelsLikeF Feels like temperature in fahrenheit
 * @param feelsLikeF Feels like temperature in fahrenheit
 * @param condition Weather condition
 * @param windMph Wind speed in miles per hour
 * @param windKph Wind speed in kilometer per hour
 * @param pressureMb Pressure in millibars
 * @param pressureIn Pressure in inches
 * @param precipMm Precipitation amount in millimeters
 * @param precipIn Precipitation amount in inches
 * @param humidity Humidity as percentage
 * @param cloud Cloud cover as percentage
 * @param isDay Whether to show day condition icon or night icon: 1=Yes 0=No
 * @param uv UV Index
 * @param gustMph Wind gust in miles per hour
 * @param gustKph Wind gust in kilometer per hour
 */
@Serializable
data class WeatherDTO(
    @SerialName("last_updated") val lastUpdated: String? = null,
    @SerialName("last_updated_epoch") val lastUpdatedEpoch: Int? = null,
    @SerialName("temp_c") val tempC: Double? = null,
    @SerialName("temp_f") val tempF: Double? = null,
    @SerialName("feelslike_c") val feelsLikeC: Double? = null,
    @SerialName("feelslike_f") val feelsLikeF: Double? = null,
    @SerialName("condition") val condition: ConditionDTO? = null,
    @SerialName("wind_mph") val windMph: Double? = null,
    @SerialName("wind_kph") val windKph: Double? = null,
    @SerialName("wind_degree") val windDegree: Double? = null,
    @SerialName("pressure_mb") val pressureMb: Double? = null,
    @SerialName("pressure_in") val pressureIn: Double? = null,
    @SerialName("precip_mm") val precipMm: Double? = null,
    @SerialName("precip_in") val precipIn: Double? = null,
    @SerialName("humidity") val humidity: Int? = null,
    @SerialName("cloud") val cloud: Int? = null,
    @SerialName("is_day") val isDay: Int? = null,
    @SerialName("uv") val uv: Double? = null,
    @SerialName("gust_mph") val gustMph: Double? = null,
    @SerialName("gust_kph") val gustKph: Double? = null,
    @SerialName("air_quality") val airQuality: AirQualityDTO? = null,
)
