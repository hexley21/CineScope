package org.hxl.network.model.series.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LastEpisodeToAirDTO(
    @Json(name = "air_date")
    val airDate: String,
    @Json(name = "episode_number")
    val episodeNumber: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "production_code")
    val productionCode: String,
    @Json(name = "runtime")
    val runtime: Int,
    @Json(name = "season_number")
    val seasonNumber: Int,
    @Json(name = "show_id")
    val showId: Int,
    @Json(name = "still_path")
    val stillPath: Any,
    @Json(name = "vote_average")
    val voteAverage: Int,
    @Json(name = "vote_count")
    val voteCount: Int
)