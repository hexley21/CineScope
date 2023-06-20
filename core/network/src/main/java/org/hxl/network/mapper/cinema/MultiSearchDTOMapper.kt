package org.hxl.network.mapper.cinema

import org.hxl.model.cinema.MultiSearchItem
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.MultiSearchItemDTO

fun MultiSearchItemDTO.mapToModel(): MultiSearchItem {
    return MultiSearchItem(
        adult,
        IMG_LOCATION + backdropPath,
        id,
        name,
        originalLanguage,
        originalName,
        overview,
        IMG_LOCATION + posterPath,
        mediaType,
        genreIds,
        popularity,
        firstAirDate,
        voteAverage,
        voteCount,
        originCountry,
        title,
        originalTitle,
        releaseDate,
        video
    )
}