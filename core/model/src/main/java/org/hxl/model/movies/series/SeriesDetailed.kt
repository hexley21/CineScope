package org.hxl.model.movies.series


import org.hxl.model.movies.detail.ProductionCountry
import org.hxl.model.movies.detail.SpokenLanguage
import org.hxl.model.movies.series.detail.LastEpisodeToAir
import org.hxl.model.movies.series.detail.Network
import org.hxl.model.movies.series.detail.Season

data class SeriesDetailed(
    val adult: Boolean,
    val backdropPath: String,
    val createdBy: List<Any>,
    val episodeRunTime: List<Any>,
    val firstAirDate: String,
    val genres: List<Any>,
    val homepage: String,
    val id: Int,
    val inProduction: Boolean,
    val languages: List<String>,
    val lastAirDate: String,
    val lastEpisodeToAir: LastEpisodeToAir,
    val name: String,
    val networks: List<Network>,
    val nextEpisodeToAir: Any,
    val numberOfEpisodes: Int,
    val numberOfSeasons: Int,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<Any>,
    val productionCountries: List<ProductionCountry>,
    val seasons: List<Season>,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val type: String,
    val voteAverage: Int,
    val voteCount: Int
)