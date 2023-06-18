package org.hxl.data.repository.pref

interface PreferenceLocalRepository {
    suspend fun get(key: String, default: Int): Int
    suspend fun get(key: String, default: Boolean): Boolean
    suspend fun get(key: String, default: String): String

    suspend fun set(key: String, value: Int)
    suspend fun set(key: String, value: Boolean)
    suspend fun set(key: String, value: String)
}