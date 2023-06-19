package org.hxl.network

import org.hxl.data.repository.movie.MovieRepositoryRemote
import org.hxl.model.movies.MultiSearch
import org.hxl.model.movies.movie.MovieDetailed
import org.hxl.model.movies.movie.MovieListItem
import org.hxl.model.movies.series.SeriesDetailed
import org.hxl.model.movies.series.SeriesListItem
import org.hxl.network.api.movie.MovieService
import org.hxl.network.mapper.mapToModel
import org.hxl.network.mapper.movie.mapToModel
import org.hxl.network.mapper.series.mapToModel

class MovieRepositoryRemoteImpl(private val movieService: MovieService): MovieRepositoryRemote {
    override suspend fun getPopularMovies(
        language: String,
        page: Int,
        region: String
    ): List<MovieListItem> {
        return movieService.getPopularMovies(language, page, region).results.map { it.mapToModel() }
    }

    override suspend fun getPopularMovies(language: String, page: Int): List<MovieListItem> {
        return movieService.getPopularMovies(language, page).results.map { it.mapToModel() }
    }

    override suspend fun getTopMovies(
        language: String,
        page: Int,
        region: String
    ): List<MovieListItem> {
        return movieService.getTopMovies(language, page, region).results.map { it.mapToModel() }
    }

    override suspend fun getTopMovies(language: String, page: Int): List<MovieListItem> {
        return movieService.getTopMovies(language, page).results.map { it.mapToModel() }
    }

    override suspend fun getMovieById(id: String, language: String): MovieDetailed {
        return movieService.getMovieById(id, language).mapToModel()
    }

    override suspend fun getPopularSeries(language: String, page: Int): List<SeriesListItem> {
        return movieService.getPopularSeries(language, page).results.map { it.mapToModel() }
    }

    override suspend fun getTopSeries(language: String, page: Int): List<SeriesListItem> {
        return movieService.getTopSeries(language, page).results.map { it.mapToModel() }
    }

    override suspend fun getSeriesById(id: String, language: String): SeriesDetailed {
        return movieService.getSeriesById(id, language).mapToModel()
    }

    override suspend fun searchMulti(
        query: String,
        includeAdult: Boolean,
        language: String,
        page: Int
    ): List<MultiSearch> {
        return movieService.searchMulti(query, includeAdult, language, page).results.map { it.mapToModel() }
    }
}