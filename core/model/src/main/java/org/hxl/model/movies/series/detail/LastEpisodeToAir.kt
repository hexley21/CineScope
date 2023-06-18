package org.hxl.model.movies.series.detail

data class LastEpisodeToAir(
    val airDate: String,
    val episodeNumber: Int,
    val id: Int,
    val name: String,
    val overview: String,
    val productionCode: String,
    val runtime: Int,
    val seasonNumber: Int,
    val showId: Int,
    val stillPath: Any,
    val voteAverage: Int,
    val voteCount: Int
)