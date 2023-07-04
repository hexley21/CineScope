package org.hxl.network.mapper.cinema

import org.hxl.model.cinema.MultiSearchItem
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.MultiSearchItemDTO

fun MultiSearchItemDTO.mapToModel(): MultiSearchItem {
    return MultiSearchItem(
        adult,
        if (backdropPath != null) IMG_LOCATION + backdropPath else null,
        id,
        name,
        originalLanguage,
        originalName,
        overview,
        if (posterPath != null) IMG_LOCATION + posterPath else null,
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
        video,
        gender,
        knownForDepartment,
        if (profilePath != null) IMG_LOCATION + profilePath else null
    )
}