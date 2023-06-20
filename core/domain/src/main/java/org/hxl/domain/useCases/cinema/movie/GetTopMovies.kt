package org.hxl.domain.useCases.cinema.movie

import org.hxl.domain.repository.CinemaRepository
import org.hxl.model.cinema.movie.MovieListItem

class GetTopMovies(private val repository: CinemaRepository) {
    suspend fun invoke(language: String, page: Int, region: String): List<MovieListItem> {
        return repository.getTopMovies(language, page, region)
    }

    suspend fun invoke(language: String, page: Int): List<MovieListItem> {
        return repository.getTopMovies(language, page)
    }
}