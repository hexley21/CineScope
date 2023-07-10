package org.hxl.network.mapper.cinema.series.detail


import org.hxl.model.cinema.series.detail.NextEpisodeToAir
import org.hxl.network.model.cinema.series.detail.NextEpisodeToAirDTO

fun NextEpisodeToAirDTO.mapToModel(): NextEpisodeToAir {
    return NextEpisodeToAir(
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
