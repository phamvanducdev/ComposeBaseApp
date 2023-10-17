package com.ducpv.cba.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by pvduc9773 on 25/09/2023.
 * DTO (Data Transfer Object) matching expected JSON Condition Object from https://www.weatherapi.com/
 * @param date Forecast date
 * @param dateEpoch Forecast date as unix time
 */
@Serializable
data class ForecastDayDTO(
    @SerialName("date") val date: String? = null,
    @SerialName("date_epoch") val dateEpoch: Int? = null,
    @SerialName("day") val day: DayDTO? = null,
    @SerialName("hour") val hour: List<HourDTO>? = null,
    @SerialName("astro") val astro: AstroDTO? = null,
)