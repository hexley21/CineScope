package org.hxl.cinescope.di

import org.hxl.domain.useCases.cinema.SearchMulti
import org.hxl.domain.useCases.cinema.movie.GetMovieById
import org.hxl.domain.useCases.cinema.movie.GetMovies
import org.hxl.domain.useCases.cinema.movie.GetPopularMovies
import org.hxl.domain.useCases.cinema.movie.GetTopMovies
import org.hxl.domain.useCases.cinema.series.GetSeries
import org.hxl.domain.useCases.cinema.series.GetSeriesById
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
    factory<GetMovies> {
        GetMovies(repository = get())
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
    factory<GetTopMovies> {
        GetTopMovies(repository = get())
    }
    factory<GetPopularMovies> {
        GetPopularMovies(repository = get())
    }
    factory<GetMovieById> {
        GetMovieById(repository = get())
    }
}