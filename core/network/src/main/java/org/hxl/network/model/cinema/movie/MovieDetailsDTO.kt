package org.hxl.network.model.cinema.movie


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.hxl.network.model.cinema.detail.GenreDTO
import org.hxl.network.model.cinema.detail.ProductionCompanyDTO
import org.hxl.network.model.cinema.detail.ProductionCountryDTO
import org.hxl.network.model.cinema.detail.SpokenLanguageDTO
import org.hxl.network.model.cinema.movie.detail.BelongsToCollectionDTO

@JsonClass(generateAdapter = true)
data class MovieDetailsDTO(
    @Json(name = "adult")
    val adult: Boolean?,
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    @Json(name = "belongs_to_collection")
    val belongsToCollection: BelongsToCollectionDTO?,
    @Json(name = "budget")
    val budget: Int?,
    @Json(name = "genres")
    val genres: List<GenreDTO?>?,
    @Json(name = "homepage")
    val homepage: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "imdb_id")
    val imdbId: String?,
    @Json(name = "original_language")
    val originalLanguage: String?,
    @Json(name = "original_title")
    val originalTitle: String?,
    @Json(name = "overview")
    val overview: String?,
    @Json(name = "popularity")
    val popularity: Double?,
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompanyDTO?>?,
    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountryDTO?>?,
    @Json(name = "release_date")
    val releaseDate: String?,
    @Json(name = "revenue")
    val revenue: Int?,
    @Json(name = "runtime")
    val runtime: Int?,
    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguageDTO?>?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "tagline")
    val tagline: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "video")
    val video: Boolean?,
    @Json(name = "vote_average")
    val voteAverage: Double?,
    @Json(name = "vote_count")
    val voteCount: Int?
)