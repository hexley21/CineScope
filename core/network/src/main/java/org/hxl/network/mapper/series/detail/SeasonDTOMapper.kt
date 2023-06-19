package org.hxl.network.mapper.series.detail

import org.hxl.model.movies.series.detail.Season
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.series.detail.SeasonDTO

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