package org.hxl.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import org.hxl.data.repository.pref.PreferenceLocalRepository

class PreferenceDataStore(private val context: Context): PreferenceLocalRepository {

    companion object {
        private const val dataStoreKey: String = "cinescope_prefs"
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = dataStoreKey)
    override suspend fun get(key: String, default: Int): Int {
        return context.dataStore.data.first()[intPreferencesKey(key)] ?: default
    }

    override suspend fun get(key: String, default: Boolean): Boolean {
        return context.dataStore.data.first()[booleanPreferencesKey(key)] ?: default
    }

    override suspend fun get(key: String, default: String): String {
        return context.dataStore.data.first()[stringPreferencesKey(key)] ?: default
    }

    override suspend fun set(key: String, value: Int) {
        context.dataStore.edit { it[intPreferencesKey(key)] = value }
    }

    override suspend fun set(key: String, value: Boolean) {
        context.dataStore.edit { it[booleanPreferencesKey(key)] = value }
    }

    override suspend fun set(key: String, value: String) {
        context.dataStore.edit { it[stringPreferencesKey(key)] = value }
    }


}