package org.hxl.domain.repository

import org.hxl.model.movies.MultiSearch
import org.hxl.model.movies.movie.MovieDetailed
import org.hxl.model.movies.movie.MovieListItem
import org.hxl.model.movies.series.SeriesDetailed
import org.hxl.model.movies.series.SeriesListItem

interface MovieRepository {
    suspend fun getPopularMovies(language: String, page: Int, region: String): List<MovieListItem>
    suspend fun getPopularMovies(language: String, page: Int): List<MovieListItem>
    suspend fun getTopMovies(language: String, page: Int, region: String): List<MovieListItem>
    suspend fun getTopMovies(language: String, page: Int): List<MovieListItem>
    suspend fun getMovieById(id: String, language: String): MovieDetailed

    suspend fun getPopularSeries(language: String, page: Int): List<SeriesListItem>
    suspend fun getTopSeries(language: String, page: Int): List<SeriesListItem>
    suspend fun getSeriesById(id: String, language: String): SeriesDetailed

    suspend fun searchMulti(query: String, includeAdult: Boolean, language: String, page: Int): List<MultiSearch>
}