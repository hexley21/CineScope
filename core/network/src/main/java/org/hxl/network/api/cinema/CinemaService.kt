package org.hxl.network.api.cinema

import org.hxl.network.model.cinema.ListResponse
import org.hxl.network.model.cinema.MultiSearchItemDTO
import org.hxl.network.model.cinema.movie.MovieDetailsDTO
import org.hxl.network.model.cinema.movie.MovieListItemDTO
import org.hxl.network.model.cinema.series.SeriesDetailsDTO
import org.hxl.network.model.cinema.series.SeriesListItemDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CinemaService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): ListResponse<MovieListItemDTO>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): ListResponse<MovieListItemDTO>

    @GET("movie/top_rated")
    suspend fun getTopMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): ListResponse<MovieListItemDTO>

    @GET("movie/top_rated")
    suspend fun getTopMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): ListResponse<MovieListItemDTO>

    @GET("movie/{id}")
    suspend fun getMovieById(
        @Path("id") id: Int,
        @Query("language") language: String
    ): MovieDetailsDTO


    @GET("tv/popular")
    suspend fun getPopularSeries(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): ListResponse<SeriesListItemDTO>

    @GET("movie/top_rated")
    suspend fun getTopSeries(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): ListResponse<SeriesListItemDTO>

    @GET("tv/{id}")
    suspend fun getSeriesById(
        @Path("id") id: Int,
        @Query("language") language: String
    ): SeriesDetailsDTO


    @GET("search/multi")
    suspend fun searchMulti(
        @Query("query") query: String,
        @Query("include_adult") includeAdult: Boolean,
        @Query("language") language: String,
        @Query("page") page: Int
    ): ListResponse<MultiSearchItemDTO>
}