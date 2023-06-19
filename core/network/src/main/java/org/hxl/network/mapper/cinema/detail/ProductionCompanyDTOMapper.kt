package org.hxl.network.mapper.cinema.detail

import org.hxl.model.cinema.detail.ProductionCompany
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.detail.ProductionCompanyDTO

fun ProductionCompanyDTO.mapToModel(): ProductionCompany {
    return ProductionCompany(
        id,
        IMG_LOCATION + logoPath,
        name,
        originCountry
    )
}