package org.hxl.network.mapper

import org.hxl.model.movies.MultiSearch
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.MultiSearchDTO

fun MultiSearchDTO.mapToModel(): MultiSearch {
    return MultiSearch(
        adult,
        IMG_LOCATION + backdropPath,
        firstAirDate,
        genreIds,
        id,
        mediaType,
        name,
        originCountry,
        originalLanguage,
        originalName,
        originalTitle,
        overview,
        popularity,
        IMG_LOCATION + posterPath,
        releaseDate,
        title,
        video,
        voteAverage,
        voteCount
    )
}
