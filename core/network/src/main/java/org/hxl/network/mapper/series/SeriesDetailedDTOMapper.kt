package org.hxl.network.mapper.series

import org.hxl.model.movies.series.SeriesDetailed
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.mapper.detail.mapToModel
import org.hxl.network.mapper.series.detail.mapToModel
import org.hxl.network.model.series.SeriesDetailedDTO

fun SeriesDetailedDTO.mapToModel(): SeriesDetailed {
    return SeriesDetailed(
        adult,
        IMG_LOCATION + backdropPath,
        createdBy,
        episodeRunTime,
        firstAirDate,
        genres,
        homepage,
        id,
        inProduction,
        languages,
        lastAirDate,
        lastEpisodeToAir.mapToModel(),
        name,
        networks.map { it.mapToModel() },
        nextEpisodeToAir,
        numberOfEpisodes,
        numberOfSeasons,
        originCountry,
        originalLanguage,
        originalName,
        overview,
        popularity,
        IMG_LOCATION + posterPath,
        productionCompanies,
        productionCountries.map { it.mapToModel() },
        seasons.map { it.mapToModel() },
        spokenLanguages.map { it.mapToModel() },
        status,
        tagline,
        type,
        voteAverage,
        voteCount
    )
}