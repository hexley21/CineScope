package org.hxl.domain.useCases.prefs

import org.hxl.domain.repository.PreferenceRepository
import org.hxl.model.PrefKeys

class CinemaResultUseCase(private val repository: PreferenceRepository): PreferenceUseCase<Int> {
    override suspend fun set(value: Int) {
        repository.set(PrefKeys.CINEMA_RESULT_KEY, value)
    }

    override suspend fun get(): Int {
        return repository.get(PrefKeys.CINEMA_RESULT_KEY, PrefKeys.CINEMA_RESULT_DEFAULT)
    }
}