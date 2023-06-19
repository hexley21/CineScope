package org.hxl.network.mapper.cinema

import org.hxl.model.cinema.MultiSearch
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.MultiSearchDTO

fun MultiSearchDTO.mapToModel(): MultiSearch {
    return MultiSearch(
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