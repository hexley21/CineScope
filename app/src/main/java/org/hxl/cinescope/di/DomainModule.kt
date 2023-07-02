package org.hxl.cinescope.di

import org.hxl.domain.useCases.cinema.SearchMulti
import org.hxl.domain.useCases.cinema.movie.GetMovieById
import org.hxl.domain.useCases.cinema.movie.GetMoviesUseCase
import org.hxl.domain.useCases.cinema.series.GetSeries
import org.hxl.domain.useCases.cinema.series.GetSeriesById
import org.hxl.domain.useCases.prefs.CinemaResultUseCase
import org.hxl.domain.useCases.prefs.OnboardSkipUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<OnboardSkipUseCase> {
        OnboardSkipUseCase(preferenceRepository = get())
    }
    factory<CinemaResultUseCase> {
        CinemaResultUseCase(repository = get())
    }
    factory<GetMoviesUseCase> {
        GetMoviesUseCase(repository = get())
    }
    factory<GetSeriesById> {
        GetSeriesById(repository = get())
    }
    factory<GetSeries> {
        GetSeries(repository = get())
    }
    factory<SearchMulti> {
        SearchMulti(repository = get())
    }
    factory<GetMovieById> {
        GetMovieById(repository = get())
    }
}