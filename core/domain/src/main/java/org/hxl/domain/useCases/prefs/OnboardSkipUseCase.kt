package org.hxl.domain.useCases.prefs

import kotlinx.coroutines.flow.Flow
import org.hxl.domain.repository.PreferenceRepository
import org.hxl.model.PrefKeys

class OnboardSkipUseCase(private val preferenceRepository: PreferenceRepository): PreferenceUseCase<Boolean> {

    override suspend fun set(value: Boolean) {
        preferenceRepository.set(PrefKeys.ONBOARD_SKIP_KEY, value)
    }

    override suspend fun get(): Boolean {
        return preferenceRepository.get(PrefKeys.ONBOARD_SKIP_KEY, PrefKeys.ONBOARD_SKIP_DEFAULT)
    }

    override fun getFlow(): Flow<Boolean> {
        return preferenceRepository.getFlow(PrefKeys.ONBOARD_SKIP_KEY, PrefKeys.ONBOARD_SKIP_DEFAULT)
    }
}