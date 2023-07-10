package org.hxl.domain.useCases.cinema.movie

import org.hxl.domain.repository.CinemaRepository
import org.hxl.domain.useCases.cinema.GetCinemaById
import org.hxl.model.cinema.movie.MovieDetails

class GetMovieById(private val repository: CinemaRepository): GetCinemaById<MovieDetails> {
    override suspend fun details(id: Int, language: String): MovieDetails {
        return repository.getMovieById(id, language)
    }
}