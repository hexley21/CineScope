package org.hxl.network.mapper.cinema.series.detail

import org.hxl.model.cinema.series.detail.EpisodeToAir
import org.hxl.network.mapper.MapperConstants
import org.hxl.network.model.cinema.series.detail.EpisodeToAirDTO

fun EpisodeToAirDTO.mapToModel(): EpisodeToAir {
    return EpisodeToAir(
        id,
        name,
        overview,
        voteAverage,
        voteCount,
        airDate,
        episodeNumber,
        productionCode,
        runtime,
        seasonNumber,
        showId,
        "${ MapperConstants.IMG_LOCATION }/$stillPath"
    )
}