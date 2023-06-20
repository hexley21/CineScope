package org.hxl.data

import org.hxl.domain.repository.CinemaRepository
import org.hxl.model.cinema.MultiSearch
import org.hxl.model.cinema.movie.MovieDetails
import org.hxl.model.cinema.movie.MovieListItem
import org.hxl.model.cinema.series.SeriesDetails
import org.hxl.model.cinema.series.SeriesListItem

class CinemaRepositoryImpl: CinemaRepository {
    override suspend fun getPopularMovies(
        language: String,
        page: Int,
        region: String
    ): List<MovieListItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getPopularMovies(language: String, page: Int): List<MovieListItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopMovies(
        language: String,
        page: Int,
        region: String
    ): List<MovieListItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopMovies(language: String, page: Int): List<MovieListItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieById(id: Int, language: String): MovieDetails {
        TODO("Not yet implemented")
    }

    override suspend fun getPopularSeries(language: String, page: Int): List<SeriesListItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopSeries(language: String, page: Int): List<SeriesListItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getSeriesById(id: Int, language: String): SeriesDetails {
        TODO("Not yet implemented")
    }

    override suspend fun searchMulti(
        query: String,
        includeAdult: Boolean,
        language: String,
        page: Int
    ): List<MultiSearch> {
        TODO("Not yet implemented")
    }
}