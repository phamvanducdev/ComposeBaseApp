package com.ducpv.cba.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by pvduc9773 on 24/09/2023.
 * DTO (Data Transfer Object) matching expected JSON Condition Object from https://www.weatherapi.com/
 * @param text Weather condition text
 * @param icon Weather icon url
 * @param code Weather condition unique code
 */
@Serializable
data class ConditionDTO(
    @SerialName("text") val text: String? = null,
    @SerialName("icon") val icon: String? = null,
    @SerialName("code") val code: Int? = null,
)