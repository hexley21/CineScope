package org.hxl.network.mapper.detail

import org.hxl.model.movies.detail.ProductionCountry
import org.hxl.network.model.detail.ProductionCountryDTO

fun ProductionCountryDTO.mapToModel(): ProductionCountry {
    return ProductionCountry(
        iso31661,
        name
    )
}