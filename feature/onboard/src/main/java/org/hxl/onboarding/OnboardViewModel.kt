package org.hxl.onboarding

import android.util.Log
import androidx.lifecycle.ViewModel
import org.hxl.domain.useCases.prefs.OnboardSkipUseCase

class OnboardViewModel(
    private val getOnboardSkip: OnboardSkipUseCase
): ViewModel() {

    companion object {
        private const val TAG: String = "OnboardVM"
    }

    suspend fun isSkip(): Boolean {
        return getOnboardSkip.get()
    }

    suspend fun enableSkip() {
        getOnboardSkip.set(true)
        Log.d(TAG, "setSkip: successful")
    }

}