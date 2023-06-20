package org.hxl.onboarding

import android.util.Log
import androidx.lifecycle.ViewModel
import org.hxl.domain.useCases.prefs.GetOnboardSkip
import org.hxl.domain.useCases.prefs.SetOnboardSkip

class OnboardViewModel(
    private val getOnboardSkip: GetOnboardSkip,
    private val setOnboardSkip: SetOnboardSkip
): ViewModel() {

    companion object {
        private const val TAG: String = "OnboardVM"
    }

    suspend fun isSkip(): Boolean {
        return getOnboardSkip.invoke()
    }

    suspend fun setSkip(value: Boolean) {
        setOnboardSkip.invoke(value)
        Log.d(TAG, "setSkip: successful")
    }

}