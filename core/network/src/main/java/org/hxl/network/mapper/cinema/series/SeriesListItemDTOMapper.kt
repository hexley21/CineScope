package org.hxl.network.mapper.cinema.series

import org.hxl.model.cinema.series.SeriesListItem
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.series.SeriesListItemDTO

fun SeriesListItemDTO.mapToModel(): SeriesListItem {
    return SeriesListItem(
        IMG_LOCATION + backdropPath,
        firstAirDate,
        genreIds,
        id,
        name,
        originCountry,
        originalLanguage,
        originalName,
        overview,
        popularity,
        IMG_LOCATION + posterPath,
        voteAverage,
        voteCount
    )
}