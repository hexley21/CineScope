package org.hxl.network

import org.hxl.data.repository.movie.CinemaRepositoryRemote
import org.hxl.model.cinema.MultiSearchItem
import org.hxl.model.cinema.movie.MovieDetails
import org.hxl.model.cinema.movie.MovieListItem
import org.hxl.model.cinema.series.SeriesDetails
import org.hxl.model.cinema.series.SeriesListItem
import org.hxl.network.api.cinema.CinemaService
import org.hxl.network.mapper.cinema.mapToModel
import org.hxl.network.mapper.cinema.movie.mapToModel
import org.hxl.network.mapper.cinema.series.mapToModel

class CinemaRepositoryRemoteImpl(private val cinemaService: CinemaService): CinemaRepositoryRemote {
    override suspend fun getPopularMovies(
        language: String,
        page: Int,
        region: String
    ): List<MovieListItem> {
        return cinemaService.getPopularMovies(language, page, region).results.map { it.mapToModel() }
    }

    override suspend fun getPopularMovies(language: String, page: Int): List<MovieListItem> {
        return cinemaService.getPopularMovies(language, page).results.map { it.mapToModel() }
    }

    override suspend fun getTopMovies(
        language: String,
        page: Int,
        region: String
    ): List<MovieListItem> {
        return cinemaService.getTopMovies(language, page, region).results.map { it.mapToModel() }
    }

    override suspend fun getTopMovies(language: String, page: Int): List<MovieListItem> {
        return cinemaService.getTopMovies(language, page).results.map { it.mapToModel() }
    }

    override suspend fun getMovieById(id: Int, language: String): MovieDetails {
        return cinemaService.getMovieById(id, language).mapToModel()
    }

    override suspend fun getPopularSeries(language: String, page: Int): List<SeriesListItem> {
        return cinemaService.getPopularSeries(language, page).results.map { it.mapToModel() }
    }

    override suspend fun getTopSeries(language: String, page: Int): List<SeriesListItem> {
        return cinemaService.getTopSeries(language, page).results.map { it.mapToModel() }
    }

    override suspend fun getSeriesById(id: Int, language: String): SeriesDetails {
        return cinemaService.getSeriesById(id, language).mapToModel()
    }

    override suspend fun searchMulti(
        query: String,
        includeAdult: Boolean,
        language: String,
        page: Int
    ): List<MultiSearchItem> {
        return cinemaService.searchMulti(query, includeAdult, language, page).results.map { it.mapToModel() }
    }
}
