package org.hxl.network.mapper.series

import org.hxl.model.movies.series.SeriesListItem
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.series.SeriesListItemDTO

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
