package org.hxl.network.mapper.cinema.series

import org.hxl.model.cinema.series.SeriesDetails
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.mapper.cinema.detail.mapToModel
import org.hxl.network.mapper.cinema.series.detail.mapToModel
import org.hxl.network.model.cinema.series.SeriesDetailsDTO

fun SeriesDetailsDTO.mapToModel(): SeriesDetails {
    return SeriesDetails(
        adult,
        IMG_LOCATION + backdropPath,
        createdBy?.map { it?.mapToModel() },
        episodeRunTime,
        firstAirDate,
        genres?.map { it?.mapToModel() },
        homepage,
        id,
        inProduction,
        languages,
        lastAirDate,
        lastEpisodeToAir?.mapToModel(),
        name,
        nextEpisodeToAir?.mapToModel(),
        networks?.map { it?.mapToModel() },
        numberOfEpisodes,
        numberOfSeasons,
        originCountry,
        originalLanguage,
        originalName,
        overview,
        popularity,
        IMG_LOCATION + posterPath,
        productionCompanies?.map { it?.mapToModel() },
        productionCountries?.map { it?.mapToModel() },
        seasons?.map { it?.mapToModel() },
        spokenLanguages?.map { it?.mapToModel() },
        status,
        tagline,
        type,
        voteAverage,
        voteCount
    )
}