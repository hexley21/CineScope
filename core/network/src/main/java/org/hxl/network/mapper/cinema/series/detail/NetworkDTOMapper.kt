package org.hxl.network.mapper.cinema.series.detail

import org.hxl.model.cinema.series.detail.Network
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.series.detail.NetworkDTO

fun NetworkDTO.mapToModel(): Network {
    return Network(
        id,
        IMG_LOCATION + logoPath,
        name,
        originCountry
    )
}