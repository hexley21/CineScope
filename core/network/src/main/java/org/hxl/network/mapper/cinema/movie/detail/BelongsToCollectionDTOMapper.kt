package org.hxl.network.mapper.cinema.movie.detail

import org.hxl.model.cinema.detail.BelongsToCollection
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.movie.detail.BelongsToCollectionDTO

fun BelongsToCollectionDTO.mapToModel(): BelongsToCollection {
    return BelongsToCollection(
        id,
        name,
        "${IMG_LOCATION}/$posterPath",
        "${IMG_LOCATION}/$backdropPath"
    )
}