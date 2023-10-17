package com.ducpv.cba.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by pvduc9773 on 24/09/2023.
 * DTO (Data Transfer Object) matching expected JSON Location Object from https://www.weatherapi.com/
 * @param lat Latitude in decimal degree
 * @param lon Longitude in decimal degree
 * @param name Location name
 * @param region Region or state of the location, if availa
 * @param country Location country
 * @param tzId Time zone name
 * @param localtimeEpoch Local date and time in unix time
 * @param localtime Local date and time
 */
@Serializable
data class LocationDTO(
    @SerialName("lat") val lat: Double? = null,
    @SerialName("lon") val lon: Double? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("region") val region: String? = null,
    @SerialName("country") val country: String? = null,
    @SerialName("tz_id") val tzId: String? = null,
    @SerialName("localtime_epoch") val localtimeEpoch: Int? = null,
    @SerialName("localtime") val localtime: String? = null,
)