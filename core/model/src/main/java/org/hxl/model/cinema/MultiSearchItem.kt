package org.hxl.model.cinema

data class MultiSearchItem(
    val adult: Boolean?,
    val backdropPath: String?,
    val id: Int?,
    val name: String?,
    val originalLanguage: String?,
    val originalName: String?,
    val overview: String?,
    val posterPath: String?,
    val mediaType: String?,
    val genreIds: List<Int?>?,
    val popularity: Double?,
    val firstAirDate: String?,
    val voteAverage: Double?,
    val voteCount: Int?,
    val originCountry: List<String?>?,
    val title: String?,
    val originalTitle: String?,
    val releaseDate: String?,
    val video: Boolean?,
    val gender: Int?,
    val knownForDepartment: String?,
    val profilePath: String?
)