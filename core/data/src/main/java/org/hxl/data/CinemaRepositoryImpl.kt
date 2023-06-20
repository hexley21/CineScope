package org.hxl.data

import org.hxl.domain.repository.CinemaRepository
import org.hxl.model.cinema.MultiSearchItem
import org.hxl.model.cinema.movie.MovieDetails
import org.hxl.model.cinema.movie.MovieListItem
import org.hxl.model.cinema.series.SeriesDetails
import org.hxl.model.cinema.series.SeriesListItem

class CinemaRepositoryImpl(
    private val remote: CinemaRepository,
): CinemaRepository {

    override suspend fun getPopularMovies(
        language: String,
        page: Int,
        region: String
    ): List<MovieListItem> {
        return remote.getPopularMovies(language, page, region)
    }

    override suspend fun getPopularMovies(language: String, page: Int): List<MovieListItem> {
        return remote.getPopularMovies(language, page)
    }

    override suspend fun getTopMovies(
        language: String,
        page: Int,
        region: String
    ): List<MovieListItem> {
        return remote.getTopMovies(language, page, region)
    }

    override suspend fun getTopMovies(language: String, page: Int): List<MovieListItem> {
        return remote.getTopMovies(language, page)
    }

    override suspend fun getMovieById(id: Int, language: String): MovieDetails {
        return remote.getMovieById(id, language)
    }

    override suspend fun getPopularSeries(language: String, page: Int): List<SeriesListItem> {
        return remote.getPopularSeries(language, page)
    }

    override suspend fun getTopSeries(language: String, page: Int): List<SeriesListItem> {
        return remote.getTopSeries(language, page)
    }

    override suspend fun getSeriesById(id: Int, language: String): SeriesDetails {
        return remote.getSeriesById(id, language)
    }

    override suspend fun searchMulti(
        query: String,
        includeAdult: Boolean,
        language: String,
        page: Int
    ): List<MultiSearchItem> {
        return remote.searchMulti(query, includeAdult, language, page)
    }
}