package org.hxl.data

import kotlinx.coroutines.flow.Flow
import org.hxl.data.repository.pref.PreferenceLocalRepository
import org.hxl.domain.repository.PreferenceRepository

class PreferenceRepositoryImpl(private val preferenceLocalRepository: PreferenceLocalRepository): PreferenceRepository {
    override suspend fun get(key: String, default: Int): Int {
        return preferenceLocalRepository.get(key, default)
    }

    override suspend fun get(key: String, default: Boolean): Boolean {
        return preferenceLocalRepository.get(key, default)
    }

    override suspend fun get(key: String, default: String): String {
        return preferenceLocalRepository.get(key, default)
    }

    override fun getFlow(key: String, default: Int): Flow<Int> {
        return preferenceLocalRepository.getFlow(key, default)
    }

    override fun getFlow(key: String, default: Boolean): Flow<Boolean> {
        return preferenceLocalRepository.getFlow(key, default)
    }

    override fun getFlow(key: String, default: String): Flow<String> {
        return preferenceLocalRepository.getFlow(key, default)
    }

    override suspend fun set(key: String, value: Int) {
        preferenceLocalRepository.set(key, value)
    }

    override suspend fun set(key: String, value: Boolean) {
        preferenceLocalRepository.set(key, value)
    }

    override suspend fun set(key: String, value: String) {
        preferenceLocalRepository.set(key, value)
    }
}