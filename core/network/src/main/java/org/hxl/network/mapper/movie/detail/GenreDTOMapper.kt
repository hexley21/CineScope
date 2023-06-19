package org.hxl.network.mapper.movie.detail

import org.hxl.model.movies.movie.detail.Genre
import org.hxl.network.model.movie.detail.GenreDTO

fun GenreDTO.mapToModel(): Genre {
    return Genre(
        id,
        name
    )
}