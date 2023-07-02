package org.hxl.domain.useCases.cinema.movie

import org.hxl.domain.repository.CinemaRepository
import org.hxl.domain.useCases.cinema.CinemaUseCase
import org.hxl.model.cinema.movie.MovieListItem

class GetMovies(private val repository: CinemaRepository): CinemaUseCase<MovieListItem> {
    override suspend fun getPopular(language: String, page: Int): List<MovieListItem> {
        return repository.getPopularMovies(language, page)
    }

    override suspend fun getTop(language: String, page: Int): List<MovieListItem> {
        return repository.getTopMovies(language, page)
    }


}