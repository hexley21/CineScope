package org.hxl.model.movies.movie

import org.hxl.model.movies.detail.ProductionCountry
import org.hxl.model.movies.detail.SpokenLanguage
import org.hxl.model.movies.movie.detail.Genre
import org.hxl.model.movies.movie.detail.ProductionCompany

data class MovieDetailed(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)