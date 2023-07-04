package org.hxl.network.model.cinema


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MultiSearchItemDTO(
    @Json(name = "adult")
    val adult: Boolean?,
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "original_language")
    val originalLanguage: String?,
    @Json(name = "original_name")
    val originalName: String?,
    @Json(name = "overview")
    val overview: String?,
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "media_type")
    val mediaType: String?,
    @Json(name = "genre_ids")
    val genreIds: List<Int?>?,
    @Json(name = "popularity")
    val popularity: Double?,
    @Json(name = "first_air_date")
    val firstAirDate: String?,
    @Json(name = "vote_average")
    val voteAverage: Double?,
    @Json(name = "vote_count")
    val voteCount: Int?,
    @Json(name = "origin_country")
    val originCountry: List<String?>?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "original_title")
    val originalTitle: String?,
    @Json(name = "release_date")
    val releaseDate: String?,
    @Json(name = "video")
    val video: Boolean?,
    @Json(name = "gender")
    val gender: Int?,
    @Json(name = "known_for_department")
    val knownForDepartment: String?,
    @Json(name = "profile_path")
    val profilePath: String?
)