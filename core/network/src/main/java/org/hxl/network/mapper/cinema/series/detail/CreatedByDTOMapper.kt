package org.hxl.network.mapper.cinema.series.detail

import org.hxl.model.cinema.series.detail.CreatedBy
import org.hxl.network.model.cinema.series.detail.CreatedByDTO

fun CreatedByDTO.mapToModel(): CreatedBy {
    return CreatedBy(
        id,
        creditId,
        name,
        gender,
        profilePath
    )
}