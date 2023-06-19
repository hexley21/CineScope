package org.hxl.network.mapper.series.detail

import org.hxl.model.movies.series.detail.LastEpisodeToAir
import org.hxl.network.model.series.detail.LastEpisodeToAirDTO

fun LastEpisodeToAirDTO.mapToModel(): LastEpisodeToAir {
    return LastEpisodeToAir(
        airDate,
        episodeNumber,
        id,
        name,
        overview,
        productionCode,
        runtime,
        seasonNumber,
        showId,
        stillPath,
        voteAverage,
        voteCount
    )
}