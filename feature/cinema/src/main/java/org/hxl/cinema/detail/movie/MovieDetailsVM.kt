package org.hxl.cinema.detail.movie

import org.hxl.cinema.detail.base.BaseCinemaDetailsVM
import org.hxl.domain.useCases.cinema.movie.GetMovieById
import org.hxl.model.cinema.movie.MovieDetails

class MovieDetailsVM(getMovieById: GetMovieById): BaseCinemaDetailsVM<MovieDetails>(getMovieById)