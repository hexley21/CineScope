package org.hxl.network.model.cinema.series.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EpisodeToAirDTO(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "overview")
    val overview: String?,
    @Json(name = "vote_average")
    val voteAverage: Double?,
    @Json(name = "vote_count")
    val voteCount: Int?,
    @Json(name = "air_date")
    val airDate: String?,
    @Json(name = "episode_number")
    val episodeNumber: Int?,
    @Json(name = "production_code")
    val productionCode: String?,
    @Json(name = "runtime")
    val runtime: Int?,
    @Json(name = "season_number")
    val seasonNumber: Int?,
    @Json(name = "show_id")
    val showId: Int?,
    @Json(name = "still_path")
    val stillPath: String?
)