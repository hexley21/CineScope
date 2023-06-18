package org.hxl.network

import org.hxl.data.repository.movie.MovieRepositoryRemote
import org.hxl.model.movies.MultiSearch
import org.hxl.model.movies.movie.MovieDetailed
import org.hxl.model.movies.movie.MovieListItem
import org.hxl.model.movies.series.SeriesDetailed
import org.hxl.model.movies.series.SeriesListItem

class MovieRepositoryRemoteImpl(): MovieRepositoryRemote {
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

    override suspend fun getMovieById(id: String, language: String): MovieDetailed {
        TODO("Not yet implemented")
    }

    override suspend fun getPopularSeries(language: String, page: Int): List<SeriesListItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopSeries(language: String, page: Int): List<SeriesListItem> {
        TODO("Not yet implemented")
    }

    override suspend fun getSeriesById(id: String, language: String): SeriesDetailed {
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