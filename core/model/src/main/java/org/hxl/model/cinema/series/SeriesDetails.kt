package org.hxl.model.cinema.series

import org.hxl.model.cinema.detail.Genre
import org.hxl.model.cinema.detail.ProductionCompany
import org.hxl.model.cinema.detail.ProductionCountry
import org.hxl.model.cinema.detail.SpokenLanguage
import org.hxl.model.cinema.series.detail.CreatedBy
import org.hxl.model.cinema.series.detail.LastEpisodeToAir
import org.hxl.model.cinema.series.detail.Network
import org.hxl.model.cinema.series.detail.Season

data class SeriesDetails(
    val adult: Boolean?,
    val backdropPath: String?,
    val createdBy: List<CreatedBy?>?,
    val episodeRunTime: List<Int?>?,
    val firstAirDate: String?,
    val genres: List<Genre?>?,
    val homepage: String?,
    val id: Int?,
    val inProduction: Boolean?,
    val languages: List<String?>?,
    val lastAirDate: String?,
    val lastEpisodeToAir: LastEpisodeToAir?,
    val name: String?,
    val nextEpisodeToAir: String?,
    val networks: List<Network?>?,
    val numberOfEpisodes: Int?,
    val numberOfSeasons: Int?,
    val originCountry: List<String?>?,
    val originalLanguage: String?,
    val originalName: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val productionCompanies: List<ProductionCompany?>?,
    val productionCountries: List<ProductionCountry?>?,
    val seasons: List<Season?>?,
    val spokenLanguages: List<SpokenLanguage?>?,
    val status: String?,
    val tagline: String?,
    val type: String?,
    val voteAverage: Double?,
    val voteCount: Int?,

)