package org.hxl.domain.useCases.prefs

import kotlinx.coroutines.flow.Flow

interface PreferenceUseCase<T: Any> {
    suspend fun set(value: T)
    suspend fun get(): T
    fun getFlow(): Flow<T>
}