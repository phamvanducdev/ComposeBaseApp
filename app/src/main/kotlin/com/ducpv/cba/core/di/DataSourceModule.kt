package com.ducpv.cba.core.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.ducpv.cba.core.data.datastore.PrefsDataSource
import com.ducpv.cba.core.data.datastore.PrefsDataSourceImpl
import com.ducpv.cba.core.data.network.WeatherDataSource
import com.ducpv.cba.core.data.network.WeatherDataSourceImpl
import com.ducpv.cba.core.data.network.retrofit.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "prefs")

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun providePrefsDataStore(application: Application): DataStore<Preferences> {
        return application.dataStore
    }


    @Provides
    @Singleton
    fun providePrefsDataSourceImpl(dataStore: DataStore<Preferences>): PrefsDataSource {
        return PrefsDataSourceImpl(dataStore)
    }

    @Provides
    @Singleton
    fun provideWeatherDataSource(api: WeatherApi): WeatherDataSource {
        return WeatherDataSourceImpl(api)
    }
}