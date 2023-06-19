package org.hxl.network.mapper.movie

import org.hxl.model.movies.movie.MovieListItem
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.movie.MovieListItemDTO

fun MovieListItemDTO.mapToModel(): MovieListItem {
    return MovieListItem(
        adult,
        IMG_LOCATION + backdropPath,
        genreIds,
        id,
        originalLanguage,
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