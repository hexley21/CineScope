package org.hxl.network.api.movie

import org.hxl.network.model.ListResponse
import org.hxl.network.model.MultiSearchDTO
import org.hxl.network.model.movie.MovieDetailedDTO
import org.hxl.network.model.movie.MovieListItemDTO
import org.hxl.network.model.series.SeriesDetailedDTO
import org.hxl.network.model.series.SeriesListItemDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("/movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): ListResponse<MovieListItemDTO>

    @GET("/movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): ListResponse<MovieListItemDTO>

    @GET("/movie/top_rated")
    suspend fun getTopMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): ListResponse<MovieListItemDTO>

    @GET("/movie/top_rated")
    suspend fun getTopMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): ListResponse<MovieListItemDTO>

    @GET("/movie/{id}")
    suspend fun getMovieById(
        @Path("id") id: String,
        @Query("language") language: String
    ): MovieDetailedDTO


    @GET("/tv/popular")
    suspend fun getPopularSeries(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): ListResponse<SeriesListItemDTO>

    @GET("/movie/top_rated")
    suspend fun getTopSeries(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): ListResponse<SeriesListItemDTO>

    @GET("/tv/{id}")
    suspend fun getSeriesById(
        @Path("id") id: String,
        @Query("language") language: String
    ): SeriesDetailedDTO


    @GET("/search/multi")
    suspend fun searchMulti(
        @Query("query") query: String,
        @Query("include_adult") includeAdult: Boolean,
        @Query("language")language: String,
        @Query("page")page: Int
    ): ListResponse<MultiSearchDTO>
}