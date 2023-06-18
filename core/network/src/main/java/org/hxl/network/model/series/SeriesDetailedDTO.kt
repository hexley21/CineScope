package org.hxl.network.model.series


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.hxl.network.model.detail.ProductionCountryDTO
import org.hxl.network.model.detail.SpokenLanguageDTO
import org.hxl.network.model.series.detail.LastEpisodeToAirDTO
import org.hxl.network.model.series.detail.NetworkDTO
import org.hxl.network.model.series.detail.SeasonDTO

@JsonClass(generateAdapter = true)
data class SeriesDetailedDTO(
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backdropPath: String,
    @Json(name = "created_by")
    val createdBy: List<Any>,
    @Json(name = "episode_run_time")
    val episodeRunTime: List<Any>,
    @Json(name = "first_air_date")
    val firstAirDate: String,
    @Json(name = "genres")
    val genres: List<Any>,
    @Json(name = "homepage")
    val homepage: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "in_production")
    val inProduction: Boolean,
    @Json(name = "languages")
    val languages: List<String>,
    @Json(name = "last_air_date")
    val lastAirDate: String,
    @Json(name = "last_episode_to_air")
    val lastEpisodeToAir: LastEpisodeToAirDTO,
    @Json(name = "name")
    val name: String,
    @Json(name = "networks")
    val networks: List<NetworkDTO>,
    @Json(name = "next_episode_to_air")
    val nextEpisodeToAir: Any,
    @Json(name = "number_of_episodes")
    val numberOfEpisodes: Int,
    @Json(name = "number_of_seasons")
    val numberOfSeasons: Int,
    @Json(name = "origin_country")
    val originCountry: List<String>,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "original_name")
    val originalName: String,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "popularity")
    val popularity: Double,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "production_companies")
    val productionCompanies: List<Any>,
    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountryDTO>,
    @Json(name = "seasons")
    val seasons: List<SeasonDTO>,
    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguageDTO>,
    @Json(name = "status")
    val status: String,
    @Json(name = "tagline")
    val tagline: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "vote_average")
    val voteAverage: Int,
    @Json(name = "vote_count")
    val voteCount: Int
)