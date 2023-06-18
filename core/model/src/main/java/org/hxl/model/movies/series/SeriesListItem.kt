package org.hxl.model.movies.series

data class SeriesListItem(
    val backdropPath: String,
    val firstAirDate: String,
    val genreIds: ArrayList<Int>,
    val id: Int,
    val name: String,
    val originCountry: ArrayList<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int
)