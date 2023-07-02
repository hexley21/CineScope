package org.hxl.domain.useCases.prefs

interface PreferenceUseCase<T: Any> {
    suspend fun set(value: T)
    suspend fun get(): T
}