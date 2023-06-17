package org.hxl.cinescope.di

import org.hxl.domain.useCases.GetOnboardSkip
import org.hxl.domain.useCases.SetOnboardSkip
import org.koin.dsl.module

val domainModule = module {
    factory<GetOnboardSkip> {
        GetOnboardSkip(preferenceRepository = get())
    }
    factory<SetOnboardSkip> {
        SetOnboardSkip(preferenceRepository = get())
    }
}