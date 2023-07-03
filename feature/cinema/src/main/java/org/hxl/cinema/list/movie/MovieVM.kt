package org.hxl.cinema.list.movie

import org.hxl.cinema.list.base.BaseCinemaVM
import org.hxl.domain.useCases.cinema.movie.GetMoviesUseCase
import org.hxl.domain.useCases.prefs.CinemaResultUseCase
import org.hxl.model.cinema.movie.MovieListItem

class MovieVM(
    getMovies: GetMoviesUseCase,
    cinemaResult: CinemaResultUseCase
): BaseCinemaVM<MovieListItem>(getMovies, cinemaResult)
