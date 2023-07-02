package org.hxl.cinema.list.movie

import org.hxl.cinema.list.BaseCinemaVM
import org.hxl.domain.useCases.cinema.movie.GetMovies
import org.hxl.model.cinema.movie.MovieListItem

class MovieVM(getMovies: GetMovies): BaseCinemaVM<MovieListItem>(getMovies)