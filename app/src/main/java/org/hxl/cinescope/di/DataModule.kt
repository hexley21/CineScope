package org.hxl.cinescope.di

import org.hxl.data.CinemaRepositoryImpl
import org.hxl.data.PreferenceRepositoryImpl
import org.hxl.data.repository.movie.CinemaRepositoryRemote
import org.hxl.data.repository.pref.PreferenceLocalRepository
import org.hxl.datastore.PreferenceDataStore
import org.hxl.domain.repository.CinemaRepository
import org.hxl.domain.repository.PreferenceRepository
import org.hxl.network.CinemaRepositoryRemoteImpl
import org.koin.dsl.module

val dataModule = module {
    single<PreferenceLocalRepository> {
        PreferenceDataStore(context = get())
    }
    single<PreferenceRepository> {
        PreferenceRepositoryImpl(preferenceLocalRepository = get())
    }

    single<CinemaRepositoryRemote> {
        CinemaRepositoryRemoteImpl(cinemaService = get())
    }
    single<CinemaRepository> {
        CinemaRepositoryImpl(remote = get())
    }
}