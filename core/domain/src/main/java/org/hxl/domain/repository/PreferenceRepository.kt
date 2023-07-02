package org.hxl.domain.repository

import kotlinx.coroutines.flow.Flow

interface PreferenceRepository {
    suspend fun get(key: String, default: Int): Int
    suspend fun get(key: String, default: Boolean): Boolean
    suspend fun get(key: String, default: String): String

    fun getFlow(key: String, default: Int): Flow<Int>
    fun getFlow(key: String, default: Boolean): Flow<Boolean>
    fun getFlow(key: String, default: String): Flow<String>

    suspend fun set(key: String, value: Int)
    suspend fun set(key: String, value: Boolean)
    suspend fun set(key: String, value: String)
}