package org.hxl.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.hxl.data.repository.pref.PreferenceLocalRepository

class PreferenceDataStore(private val context: Context): PreferenceLocalRepository {

    companion object {
        private const val TAG = "DataStore"
        private const val dataStoreKey: String = "cinescope_prefs"
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = dataStoreKey)
    override suspend fun get(key: String, default: Int): Int {
        Log.d(TAG, "get: $key")
        return context.dataStore.data.first()[intPreferencesKey(key)] ?: default
    }

    override suspend fun get(key: String, default: Boolean): Boolean {
        Log.d(TAG, "get: $key")
        return context.dataStore.data.first()[booleanPreferencesKey(key)] ?: default
    }

    override suspend fun get(key: String, default: String): String {
        Log.d(TAG, "get: $key")
        return context.dataStore.data.first()[stringPreferencesKey(key)] ?: default
    }

    override fun getFlow(key: String, default: Int): Flow<Int> {
        return context.dataStore.data.map { it[intPreferencesKey(key)] ?: default }
    }

    override fun getFlow(key: String, default: Boolean): Flow<Boolean> {
        return context.dataStore.data.map { it[booleanPreferencesKey(key)] ?: default }
    }

    override fun getFlow(key: String, default: String): Flow<String> {
        return context.dataStore.data.map { it[stringPreferencesKey(key)] ?: default }
    }

    override suspend fun set(key: String, value: Int) {
        context.dataStore.edit { it[intPreferencesKey(key)] = value }
        Log.d(TAG, "set: $key = $value")
    }

    override suspend fun set(key: String, value: Boolean) {
        context.dataStore.edit { it[booleanPreferencesKey(key)] = value }
        Log.d(TAG, "set: $key = $value")
    }

    override suspend fun set(key: String, value: String) {
        context.dataStore.edit { it[stringPreferencesKey(key)] = value }
        Log.d(TAG, "set: $key = $value")
    }


}