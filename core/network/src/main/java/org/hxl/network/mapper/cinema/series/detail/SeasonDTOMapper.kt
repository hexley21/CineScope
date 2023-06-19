package org.hxl.network.mapper.cinema.series.detail

import org.hxl.model.cinema.series.detail.Season
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.series.detail.SeasonDTO

fun SeasonDTO.mapToModel(): Season {
    return Season(
        airDate,
        episodeCount,
        id,
        name,
        overview,
        IMG_LOCATION + posterPath,
        seasonNumber
    )
}