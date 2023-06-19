package org.hxl.network.mapper.series.detail

import org.hxl.model.movies.series.detail.Network
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.series.detail.NetworkDTO

fun NetworkDTO.mapToModel(): Network {
    return Network(
        id,
        IMG_LOCATION + logoPath,
        name,
        originCountry
    )
}