package org.hxl.network.mapper.cinema.detail

import org.hxl.model.cinema.detail.Genre
import org.hxl.network.model.cinema.detail.GenreDTO

fun GenreDTO.mapToModel(): Genre {
    return Genre(
        id,
        name
    )
}