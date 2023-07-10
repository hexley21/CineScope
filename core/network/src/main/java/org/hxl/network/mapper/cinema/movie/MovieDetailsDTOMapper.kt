package org.hxl.network.mapper.cinema.movie


import org.hxl.model.cinema.movie.MovieDetails
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.mapper.cinema.detail.mapToModel
import org.hxl.network.mapper.cinema.movie.detail.mapToModel
import org.hxl.network.model.cinema.movie.MovieDetailsDTO

fun MovieDetailsDTO.mapToModel(): MovieDetails {
    return MovieDetails(
        adult,
        IMG_LOCATION + backdropPath,
        belongsToCollection?.mapToModel(),
        budget,
        genres?.map { it?.mapToModel() },
        homepage,
        id,
        imdbId,
        originalLanguage,
        originalTitle,
        overview,
        popularity,
        IMG_LOCATION + posterPath,
        productionCompanies?.map { it?.mapToModel() },
        productionCountries?.map { it?.mapToModel() },
        releaseDate,
        revenue,
        runtime,
        spokenLanguages?.map { it?.mapToModel() },
        status,
        tagline,
        title,
        video,
        voteAverage,
        voteCount
    )
}