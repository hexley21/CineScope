package org.hxl.domain.useCases.cinema.movie

import org.hxl.domain.repository.CinemaRepository
import org.hxl.model.cinema.movie.MovieListItem

class GetPopularMovies(private val repository: CinemaRepository) {
    suspend fun invoke(language: String, page: Int, region: String): List<MovieListItem> {
        return repository.getPopularMovies(language, page, region)
    }

    suspend fun invoke(language: String, page: Int): List<MovieListItem> {
        return repository.getPopularMovies(language, page)
    }
}