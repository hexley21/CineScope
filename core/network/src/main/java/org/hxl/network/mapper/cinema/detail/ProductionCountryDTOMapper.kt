package org.hxl.network.mapper.cinema.detail

import org.hxl.model.cinema.detail.ProductionCountry
import org.hxl.network.model.cinema.detail.ProductionCountryDTO

fun ProductionCountryDTO.mapToModel(): ProductionCountry {
    return ProductionCountry(
        iso31661,
        name
    )
}