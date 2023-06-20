package org.hxl.domain.useCases.cinema.movie

import org.hxl.domain.repository.CinemaRepository
import org.hxl.model.cinema.movie.MovieDetails

class GetMovieById(private val repository: CinemaRepository) {
    suspend fun invoke(id: Int, language: String): MovieDetails {
        return repository.getMovieById(id, language)
    }
}