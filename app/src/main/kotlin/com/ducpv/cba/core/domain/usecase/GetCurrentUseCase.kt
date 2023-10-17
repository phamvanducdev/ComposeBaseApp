package com.ducpv.cba.core.domain.usecase

import com.ducpv.cba.core.data.network.ApiResponse.Companion.body
import com.ducpv.cba.core.domain.model.Current
import com.ducpv.cba.core.domain.repository.WeatherRepository
import javax.inject.Inject

class GetCurrentUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
) {
    suspend fun execute(query: String): Current? {
        return weatherRepository.getCurrent(query).body()
    }
}