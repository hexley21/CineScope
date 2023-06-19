package org.hxl.network.mapper.movie.detail

import org.hxl.model.movies.movie.detail.ProductionCompany
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.movie.detail.ProductionCompanyDTO

fun ProductionCompanyDTO.mapToModel(): ProductionCompany {
    return ProductionCompany(
        id,
        IMG_LOCATION + logoPath,
        name,
        originCountry
    )
}