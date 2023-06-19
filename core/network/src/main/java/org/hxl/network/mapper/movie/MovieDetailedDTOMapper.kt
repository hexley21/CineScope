package org.hxl.network.mapper.movie

import org.hxl.model.movies.movie.MovieDetailed
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.mapper.detail.mapToModel
import org.hxl.network.mapper.movie.detail.mapToModel
import org.hxl.network.model.movie.MovieDetailedDTO

fun MovieDetailedDTO.mapToModel(): MovieDetailed {
    return MovieDetailed(
        adult,
        IMG_LOCATION + backdropPath,
        belongsToCollection,
        budget,
        genres.map { it.mapToModel() },
        homepage,
        id,
        imdbId,
        originalLanguage,
        originalTitle,
        overview,
        popularity,
        IMG_LOCATION + posterPath,
        productionCompanies.map { it.mapToModel() },
        productionCountries.map { it.mapToModel() },
        releaseDate,
        revenue,
        runtime,
        spokenLanguages.map { it.mapToModel() },
        status,
        tagline,
        title,
        video,
        voteAverage,
        voteCount,
    )
}