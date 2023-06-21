package org.hxl.network.mapper.cinema.series

import org.hxl.model.cinema.series.SeriesListItem
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION300
import org.hxl.network.model.cinema.series.SeriesListItemDTO

fun SeriesListItemDTO.mapToModel(): SeriesListItem {
    return SeriesListItem(
        IMG_LOCATION300 + backdropPath,
        firstAirDate,
        genreIds,
        id,
        name,
        originCountry,
        originalLanguage,
        originalName,
        overview,
        popularity,
        IMG_LOCATION300 + posterPath,
        voteAverage,
        voteCount
    )
}