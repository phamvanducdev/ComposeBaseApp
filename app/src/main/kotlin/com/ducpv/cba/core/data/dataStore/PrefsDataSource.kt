package com.ducpv.cba.core.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ducpv.cba.core.data.dataStore.model.ForecastHistory
import com.ducpv.cba.core.domain.model.Forecast

interface PrefsDataSource {
    suspend fun setForecastHistory(forecast: Forecast)
    suspend fun getForecastHistory(): List<Forecast>
}

class PrefsDataSourceImpl(
    dataStore: DataStore<Preferences>,
) : PrefsDataSource, BasePrefsDataStore(dataStore) {
    companion object {
        val KEY_FORECAST_HISTORY = stringPreferencesKey("forecastHistory")
    }

    override suspend fun setForecastHistory(forecast: Forecast) {
        val forecasts = getForecastHistory().toMutableSet()
        forecasts.add(forecast)
        setObject(
            KEY_FORECAST_HISTORY,
            ForecastHistory(forecasts.toList())
        )
    }

    override suspend fun getForecastHistory(): List<Forecast> {
        val forecastHistory = getObject<ForecastHistory>(KEY_FORECAST_HISTORY)
        return forecastHistory?.forecast.orEmpty()
    }
}