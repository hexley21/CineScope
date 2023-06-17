package org.hxl.cinescope.di

import org.hxl.data.PreferenceRepositoryImpl
import org.hxl.data.repository.PreferenceLocalRepository
import org.hxl.datastore.PreferenceDataStore
import org.hxl.domain.repository.PreferenceRepository
import org.koin.dsl.module

val dataModule = module {
    single<PreferenceLocalRepository> {
        PreferenceDataStore(context = get())
    }
    single<PreferenceRepository> {
        PreferenceRepositoryImpl(preferenceLocalRepository = get())
    }
}