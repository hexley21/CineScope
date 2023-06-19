package org.hxl.data.repository.movie

import org.hxl.model.cinema.MultiSearch
import org.hxl.model.cinema.movie.MovieDetails
import org.hxl.model.cinema.movie.MovieListItem
import org.hxl.model.cinema.series.SeriesDetails
import org.hxl.model.cinema.series.SeriesListItem

interface MovieRepositoryRemote {
    suspend fun getPopularMovies(language: String, page: Int, region: String): List<MovieListItem>
    suspend fun getPopularMovies(language: String, page: Int): List<MovieListItem>
    suspend fun getTopMovies(language: String, page: Int, region: String): List<MovieListItem>
    suspend fun getTopMovies(language: String, page: Int): List<MovieListItem>
    suspend fun getMovieById(id: Int, language: String): MovieDetails

    suspend fun getPopularSeries(language: String, page: Int): List<SeriesListItem>
    suspend fun getTopSeries(language: String, page: Int): List<SeriesListItem>
    suspend fun getSeriesById(id: Int, language: String): SeriesDetails

    suspend fun searchMulti(query: String, includeAdult: Boolean, language: String, page: Int): List<MultiSearch>
}