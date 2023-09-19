package com.ducpv.cba.core.di

import com.ducpv.cba.core.data.network.WeatherDataSource
import com.ducpv.cba.core.domain.repository.WeatherRepository
import com.ducpv.cba.core.domain.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by pvduc9773 on 25/09/2023.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(dataSource: WeatherDataSource): WeatherRepository {
        return WeatherRepositoryImpl(dataSource)
    }
}