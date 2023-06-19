package org.hxl.model.cinema.movie


import org.hxl.model.cinema.detail.Genre
import org.hxl.model.cinema.detail.ProductionCompany
import org.hxl.model.cinema.detail.ProductionCountry
import org.hxl.model.cinema.detail.SpokenLanguage

data class MovieDetails(
    val adult: Boolean?,
    val backdropPath: String?,
    val belongsToCollection: String?,
    val budget: Int?,
    val genres: List<Genre?>?,
    val homepage: String?,
    val id: Int?,
    val imdbId: String?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val productionCompanies: List<ProductionCompany?>?,
    val productionCountries: List<ProductionCountry?>?,
    val releaseDate: String?,
    val revenue: Int?,
    val runtime: Int?,
    val spokenLanguages: List<SpokenLanguage?>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?
)