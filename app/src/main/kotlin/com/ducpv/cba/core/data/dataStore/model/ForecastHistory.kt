package com.ducpv.cba.core.data.dataStore.model

import com.ducpv.cba.core.domain.model.Forecast
import kotlinx.serialization.Serializable

@Serializable
data class ForecastHistory(
    val forecast: List<Forecast> = emptyList()
)