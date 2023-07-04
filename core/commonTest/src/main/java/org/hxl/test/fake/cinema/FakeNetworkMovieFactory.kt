package org.hxl.test.fake.cinema

import org.hxl.network.model.cinema.ListResponse
import org.hxl.network.model.cinema.MultiSearchItemDTO
import org.hxl.network.model.cinema.detail.GenreDTO
import org.hxl.network.model.cinema.detail.ProductionCompanyDTO
import org.hxl.network.model.cinema.detail.ProductionCountryDTO
import org.hxl.network.model.cinema.detail.SpokenLanguageDTO
import org.hxl.network.model.cinema.movie.MovieDetailsDTO
import org.hxl.network.model.cinema.movie.MovieListItemDTO
import org.hxl.network.model.cinema.series.SeriesDetailsDTO
import org.hxl.network.model.cinema.series.SeriesListItemDTO
import org.hxl.network.model.cinema.series.detail.CreatedByDTO
import org.hxl.network.model.cinema.series.detail.LastEpisodeToAirDTO
import org.hxl.network.model.cinema.series.detail.NetworkDTO
import org.hxl.network.model.cinema.series.detail.SeasonDTO
import org.hxl.test.fake.TestConstants.PAGES
import java.util.UUID.randomUUID
import kotlin.random.Random

object FakeNetworkMovieFactory {
    fun getMovieListResponse(size: Int): ListResponse<MovieListItemDTO> {
        return ListResponse(PAGES, List(size) { getMovieListItemDTO() }, PAGES, size)
    }

    fun getSeriesListResponse(size: Int, genres: Int, countries: Int): ListResponse<SeriesListItemDTO> {
        return ListResponse(PAGES, List(size) { getSeriesListItemDTO(genres, countries) }, PAGES, size)
    }

    fun getMultiSearchListResponse(size: Int, genres: Int, countries: Int): ListResponse<MultiSearchItemDTO> {
        return ListResponse(PAGES, List(size) { getMultiSearchDTO(genres, countries) }, PAGES, size)
    }

    private fun getMultiSearchDTO(genres: Int, countries: Int): MultiSearchItemDTO {
        return MultiSearchItemDTO(
            Random.nextBoolean(),
            randomUUID().toString(),
            Random.nextInt(),
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            List(genres) { Random.nextInt() },
            Random.nextDouble(),
            randomUUID().toString(),
            Random.nextDouble(),
            Random.nextInt(),
            List(countries) { randomUUID().toString() },
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            Random.nextBoolean(),
            Random.nextInt(),
            randomUUID().toString(),
            randomUUID().toString()
        )
    }

    private fun getSeriesListItemDTO(genres: Int, countries: Int): SeriesListItemDTO {
        return SeriesListItemDTO(
            randomUUID().toString(),
            randomUUID().toString(),
            List(genres) { Random.nextInt() } ,
            Random.nextInt(),
            randomUUID().toString(),
            List(countries) { randomUUID().toString() },
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            Random.nextDouble(),
            randomUUID().toString(),
            Random.nextDouble(),
            Random.nextInt(),
        )
    }

    fun getMovieListItemDTO(): MovieListItemDTO {
        return MovieListItemDTO(
            Random.nextBoolean(),
            randomUUID().toString(),
            emptyList(),
            Random.nextInt(),
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            Random.nextDouble(),
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            Random.nextBoolean(),
            Random.nextDouble(),
            Random.nextInt()
        )
    }

    fun getSeriesDetailsDTO(
        createdBy: Int,
        genres: Int,
        languages: Int,
        network: Int,
        countries: Int,
        companies: Int,
        prodCountries: Int,
        seasons: Int,
        spokenLanguages: Int
    ): SeriesDetailsDTO {
        return SeriesDetailsDTO(
            Random.nextBoolean(),
            randomUUID().toString(),
            List(createdBy) { getCreatedByDTO() },
            List(genres) { Random.nextInt() },
            randomUUID().toString(),
            List(genres) { getGenreDTO() },
            randomUUID().toString(),
            Random.nextInt(),
            Random.nextBoolean(),
            List(languages) { randomUUID().toString() },
            randomUUID().toString(),
            getLastEpisodeToAirDTO(),
            randomUUID().toString(),
            randomUUID().toString(),
            List(network) { getNetworkDTO() },
            Random.nextInt(),
            Random.nextInt(),
            List(countries) { randomUUID().toString() },
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            Random.nextDouble(),
            randomUUID().toString(),
            List(companies) { getProductionCompanyDTO() },
            List(prodCountries) { getProductionCountryDTO() },
            List(seasons) { getSeasonsDTO() },
            List(spokenLanguages) { getSpokenLanguageDTO() },
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            Random.nextDouble(),
            Random.nextInt()
        )
    }

    fun getCreatedByDTO(): CreatedByDTO {
        return CreatedByDTO(
            Random.nextInt(),
            randomUUID().toString(),
            randomUUID().toString(),
            Random.nextInt(),
            randomUUID().toString(),
        )
    }

    fun getLastEpisodeToAirDTO(): LastEpisodeToAirDTO {
        return LastEpisodeToAirDTO(
            Random.nextInt(),
            randomUUID().toString(),
            randomUUID().toString(),
            Random.nextDouble(),
            Random.nextInt(),
            randomUUID().toString(),
            Random.nextInt(),
            randomUUID().toString(),
            Random.nextInt(),
            Random.nextInt(),
            Random.nextInt(),
            randomUUID().toString(),
        )
    }

    fun getNetworkDTO(): NetworkDTO {
        return NetworkDTO(
            Random.nextInt(),
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
        )
    }

    fun getSeasonsDTO(): SeasonDTO {
        return SeasonDTO(
            randomUUID().toString(),
            Random.nextInt(),
            Random.nextInt(),
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            Random.nextInt()
        )
    }

    fun getMovieDetailsDTO(genres: Int, companies: Int, countries: Int, languages: Int): MovieDetailsDTO {
        return MovieDetailsDTO(
            Random.nextBoolean(),
            randomUUID().toString(),
            randomUUID().toString(),
            Random.nextInt(),
            List(genres) { getGenreDTO() },
            randomUUID().toString(),
            Random.nextInt(),
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            Random.nextDouble(),
            randomUUID().toString(),
            List(companies) { getProductionCompanyDTO() },
            List(countries) { getProductionCountryDTO() },
            randomUUID().toString(),
            Random.nextInt(),
            Random.nextInt(),
            List(languages) { getSpokenLanguageDTO() },
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString(),
            Random.nextBoolean(),
            Random.nextDouble(),
            Random.nextInt()
        )
    }

    fun getGenreDTO(): GenreDTO {
        return GenreDTO(
            Random.nextInt(),
            randomUUID().toString()
        )
    }

    fun getProductionCompanyDTO(): ProductionCompanyDTO {
        return ProductionCompanyDTO(
            Random.nextInt(),
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString()
        )
    }

    fun getProductionCountryDTO(): ProductionCountryDTO {
        return ProductionCountryDTO(
            randomUUID().toString(),
            randomUUID().toString()
        )
    }

    fun getSpokenLanguageDTO(): SpokenLanguageDTO {
        return SpokenLanguageDTO(
            randomUUID().toString(),
            randomUUID().toString(),
            randomUUID().toString()
        )
    }

}
