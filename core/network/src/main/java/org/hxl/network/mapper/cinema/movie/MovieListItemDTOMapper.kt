package org.hxl.network.mapper.cinema.movie

import org.hxl.model.cinema.movie.MovieListItem
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION300
import org.hxl.network.model.cinema.movie.MovieListItemDTO

fun MovieListItemDTO.mapToModel(): MovieListItem {
    return MovieListItem(
        adult,
        IMG_LOCATION300 + backdropPath,
        genreIds,
        id,
        originalLanguage,
        originalTitle,
        overview,
        popularity,
        IMG_LOCATION300 + posterPath,
        releaseDate,
        title,
        video,
        voteAverage,
        voteCount
    )
}