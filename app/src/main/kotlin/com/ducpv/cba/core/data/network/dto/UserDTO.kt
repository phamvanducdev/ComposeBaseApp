package com.ducpv.cba.core.data.network.dto

import kotlinx.serialization.Serializable

/**
 * Created by pvduc9773 on 24/09/2023.
 * DTO (Data Transfer Object) matching expected JSON Condition Object
 */
@Serializable
data class UserDTO(val id: String? = null)