package com.ducpv.cba.core.domain.model

import com.ducpv.cba.core.data.network.dto.LocationDTO
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val name: String = "",
    val region: String = "",
    val country: String = "",
    val tzId: String = "",
    val localtimeEpoch: Int = 0,
    val localtime: String = "",
)

fun LocationDTO.toLocation(): Location {
    return Location(
        lat = lat ?: 0.0,
        lon = lon ?: 0.0,
        name = name ?: "",
        region = region ?: "",
        country = country ?: "",
        tzId = tzId ?: "",
        localtimeEpoch = localtimeEpoch ?: 0,
        localtime = localtime ?: "",
    )
}