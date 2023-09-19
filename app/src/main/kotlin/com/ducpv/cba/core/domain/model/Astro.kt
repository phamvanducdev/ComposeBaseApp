package com.ducpv.cba.core.domain.model

import com.ducpv.cba.core.data.network.dto.AstroDTO
import kotlinx.serialization.Serializable

@Serializable
data class Astro(
    val sunrise: String = "",
    val sunset: String = "",
    val moonrise: String = "",
    val moonset: String = "",
    val moonPhase: String = "",
    val moonIllumination: Double = 0.0,
)

fun AstroDTO.toAstro(): Astro {
    return Astro(
        sunrise = sunrise ?: "",
        sunset = sunset ?: "",
        moonrise = moonrise ?: "",
        moonset = moonset ?: "",
        moonPhase = moonPhase ?: "",
        moonIllumination = moonIllumination ?: 0.0,
    )
}
