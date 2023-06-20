package org.hxl.cinescope.di

import org.hxl.cinescope.BuildConfig
import org.hxl.network.api.ServiceFactory
import org.hxl.network.api.cinema.CinemaService
import org.koin.dsl.module

val networkModule = module {
    single<CinemaService> {
        ServiceFactory.createCinema(BuildConfig.DEBUG, "https://api.themoviedb.org/3/", BuildConfig.API_TOKEN)
    }
}