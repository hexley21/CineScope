package org.hxl.cinescope.di

import org.hxl.domain.useCases.prefs.GetOnboardSkip
import org.hxl.domain.useCases.prefs.SetOnboardSkip
import org.koin.dsl.module

val domainModule = module {
    factory<GetOnboardSkip> {
        GetOnboardSkip(preferenceRepository = get())
    }
    factory<SetOnboardSkip> {
        SetOnboardSkip(preferenceRepository = get())
    }
}