package org.hxl.domain.useCases

import org.hxl.domain.repository.PreferenceRepository
import org.hxl.model.PrefKeys

class GetOnboardSkip(private val preferenceRepository: PreferenceRepository) {
    suspend fun invoke(): Boolean {
        return preferenceRepository.get(PrefKeys.ONBOARD_SKIP_KEY, PrefKeys.ONBOARD_SKIP_DEFAULT)
    }
}