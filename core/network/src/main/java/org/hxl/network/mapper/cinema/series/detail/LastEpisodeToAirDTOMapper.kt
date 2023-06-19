package org.hxl.network.mapper.cinema.series.detail

import org.hxl.model.cinema.series.detail.LastEpisodeToAir
import org.hxl.network.model.cinema.series.detail.LastEpisodeToAirDTO

fun LastEpisodeToAirDTO.mapToModel(): LastEpisodeToAir {
    return LastEpisodeToAir(
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
        stillPath
    )
}