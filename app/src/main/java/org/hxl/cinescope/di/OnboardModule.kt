package org.hxl.cinescope.di

import org.hxl.onboarding.OnboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val onboardModule = module {
    viewModel<OnboardViewModel> {
        OnboardViewModel(
            getOnboardSkip = get(),
            setOnboardSkip = get()
        )
    }
}