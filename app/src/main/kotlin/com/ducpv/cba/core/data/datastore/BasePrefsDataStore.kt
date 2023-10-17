package com.ducpv.cba.core.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import timber.log.Timber

abstract class BasePrefsDataStore(private val dataStore: DataStore<Preferences>) {

    @OptIn(ExperimentalSerializationApi::class)
    val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    suspend fun <T> get(key: Preferences.Key<T>): T? {
        return dataStore.data.map { it[key] }.firstOrNull()
    }

    suspend fun <T> set(key: Preferences.Key<T>, value: T) {
        dataStore.edit { it[key] = value }
    }

    suspend inline fun <reified T> setObject(key: Preferences.Key<String>, value: T) {
        try {
            set(key, json.encodeToString(value))
        } catch (e: SerializationException) {
            Timber.e("Failed to encode to string", e)
        }
    }

    suspend inline fun <reified T> getObject(key: Preferences.Key<String>): T? {
        val string = get(key) ?: return null
        return json.decodeFromString(string)
    }
}