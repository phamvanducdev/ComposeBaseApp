package com.ducpv.cba.core.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

interface PrefsDataSource {
    // TODO
}

class PrefsDataSourceImpl(
    dataStore: DataStore<Preferences>,
) : PrefsDataSource, BasePrefsDataStore(dataStore) {
    // TODO
}