package org.hxl.domain.useCases.prefs

import org.hxl.domain.repository.PreferenceRepository
import org.hxl.model.PrefKeys

class SetOnboardSkip(private val preferenceRepository: PreferenceRepository) {
    suspend fun invoke(value: Boolean) {
        preferenceRepository.set(PrefKeys.ONBOARD_SKIP_KEY, value)
    }
}