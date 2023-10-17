package com.ducpv.cba.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AstroDTO(
    @SerialName("sunrise") val sunrise: String? = null,
    @SerialName("sunset") val sunset: String? = null,
    @SerialName("moonrise") val moonrise: String? = null,
    @SerialName("moonset") val moonset: String? = null,
    @SerialName("moon_phase") val moonPhase: String? = null,
    @SerialName("moon_illumination") val moonIllumination: Double? = null,
)
