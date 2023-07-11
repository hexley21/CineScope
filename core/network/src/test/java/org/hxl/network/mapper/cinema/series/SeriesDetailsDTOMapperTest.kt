package org.hxl.network.mapper.cinema.series

import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.detail.Genre
import org.hxl.model.cinema.detail.ProductionCompany
import org.hxl.model.cinema.detail.ProductionCountry
import org.hxl.model.cinema.detail.SpokenLanguage
import org.hxl.model.cinema.series.SeriesDetails
import org.hxl.model.cinema.series.detail.CreatedBy
import org.hxl.model.cinema.series.detail.EpisodeToAir
import org.hxl.model.cinema.series.detail.Network
import org.hxl.model.cinema.series.detail.Season
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.detail.GenreDTO
import org.hxl.network.model.cinema.detail.ProductionCompanyDTO
import org.hxl.network.model.cinema.detail.ProductionCountryDTO
import org.hxl.network.model.cinema.detail.SpokenLanguageDTO
import org.hxl.network.model.cinema.series.SeriesDetailsDTO
import org.hxl.network.model.cinema.series.detail.CreatedByDTO
import org.hxl.network.model.cinema.series.detail.EpisodeToAirDTO
import org.hxl.network.model.cinema.series.detail.NetworkDTO
import org.hxl.network.model.cinema.series.detail.SeasonDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SeriesDetailsDTOMapperTest {

    private val fakeDTO = SeriesDetailsDTO(
        adult = true,
        backdropPath = "/backdrop.jpg",
        createdBy = listOf(
            CreatedByDTO(
                id = 123,
                creditId = "abc123",
                name = "John Doe",
                gender = 1,
                profilePath = "/profile.png"
            ),
            CreatedByDTO(
                id = 123,
                creditId = "def456",
                name = "Jane Doe",
                gender = 2,
                profilePath = "/profile.png"
            )
        ),
        episodeRunTime = listOf(60),
        firstAirDate = "2022-01-01",
        genres = listOf(
            GenreDTO(
                id = 1,
                name = "Action"
            ),
            GenreDTO(
                id = 2,
                name = "Adventure"
            )
        ),
        homepage = "https://example.com",
        id = 456,
        inProduction = true,
        languages = listOf("English"),
        lastAirDate = "2022-12-31",
        lastEpisodeToAir = EpisodeToAirDTO(
            id = 456,
            name = "Last Episode",
            overview = "This is the last episode",
            voteAverage = 7.8,
            voteCount = 100,
            airDate = "2023-06-01",
            episodeNumber = 10,
            productionCode = "EP10",
            runtime = 45,
            seasonNumber = 1,
            showId = 123,
            stillPath = "episode.png"
        ),
        name = "Series Name",
        nextEpisodeToAir = EpisodeToAirDTO(
            id = 456,
            name = "Last Episode",
            overview = "This is the last episode",
            voteAverage = 7.8,
            voteCount = 100,
            airDate = "2023-06-01",
            episodeNumber = 10,
            productionCode = "EP10",
            runtime = 45,
            seasonNumber = 1,
            showId = 123,
            stillPath = "episode.png"
        ),
        networks = listOf(
            NetworkDTO(
                id = 123,
                logoPath = "/network_logo.png",
                name = "Network Name1",
                originCountry = "US"
            ),
            NetworkDTO(
                id = 234,
                logoPath = "/network_logo.png",
                name = "Network Name2",
                originCountry = "UK"
            )
        ),
        numberOfEpisodes = 10,
        numberOfSeasons = 2,
        originCountry = listOf("US"),
        originalLanguage = "en",
        originalName = "Original Name",
        overview = "Series Overview",
        popularity = 7.8,
        posterPath = "/poster.jpg",
        productionCompanies = listOf(
            ProductionCompanyDTO(
                id = 1,
                logoPath = "/logo.png",
                name = "Company A",
                originCountry = "US"
            ),
            ProductionCompanyDTO(
                id = 2,
                logoPath = "/logo2.png",
                name = "Company B",
                originCountry = "UK"
            )
        ),
        productionCountries = listOf(
            ProductionCountryDTO(
                iso31661 = "US",
                name = "United States"
            ),
            ProductionCountryDTO(
                iso31661 = "UK",
                name = "United Kingdom"
            )
        ),
        seasons = listOf(
            SeasonDTO(
                airDate = "2022-01-01",
                episodeCount = 10,
                id = 456,
                name = "Season Name1",
                overview = "Season Overview",
                posterPath = "/season_poster.png",
                seasonNumber = 1
            ),
            SeasonDTO(
                airDate = "2022-02-01",
                episodeCount = 10,
                id = 567,
                name = "Season Name2",
                overview = "Season Overview",
                posterPath = "/season_poster.png",
                seasonNumber = 2
            )
        ),
        spokenLanguages = listOf(
            SpokenLanguageDTO(
                englishName = "English",
                iso6391 = "en",
                name = "English"
            ),
            SpokenLanguageDTO(
                englishName = "French",
                iso6391 = "fr",
                name = "Français"
            )
        ),
        status = "Status",
        tagline = "Tagline",
        type = "Type",
        voteAverage = 8.5,
        voteCount = 100
    )

    private val fakeModel = SeriesDetails(
        adult = true,
        backdropPath = "${IMG_LOCATION}/backdrop.jpg",
        createdBy = listOf(
            CreatedBy(
                id = 123,
                creditId = "abc123",
                name = "John Doe",
                gender = 1,
                profilePath = "/profile.png"
            ),
            CreatedBy(
                id = 123,
                creditId = "def456",
                name = "Jane Doe",
                gender = 2,
                profilePath = "/profile.png"
            )
        ),
        episodeRunTime = listOf(60),
        firstAirDate = "2022-01-01",
        genres = listOf(
            Genre(
                id = 1,
                name = "Action"
            ),
            Genre(
                id = 2,
                name = "Adventure"
            )
        ),
        homepage = "https://example.com",
        id = 456,
        inProduction = true,
        languages = listOf("English"),
        lastAirDate = "2022-12-31",
        episodeToAir =
        EpisodeToAir(
            id = 456,
            name = "Last Episode",
            overview = "This is the last episode",
            voteAverage = 7.8,
            voteCount = 100,
            airDate = "2023-06-01",
            episodeNumber = 10,
            productionCode = "EP10",
            runtime = 45,
            seasonNumber = 1,
            showId = 123,
            stillPath = "${IMG_LOCATION}/episode.png"
        ),
        name = "Series Name",
        nextEpisodeToAir = EpisodeToAir(
            id = 456,
            name = "Last Episode",
            overview = "This is the last episode",
            voteAverage = 7.8,
            voteCount = 100,
            airDate = "2023-06-01",
            episodeNumber = 10,
            productionCode = "EP10",
            runtime = 45,
            seasonNumber = 1,
            showId = 123,
            stillPath = "${IMG_LOCATION}/episode.png"
        ),
        networks = listOf(
            Network(
                id = 123,
                logoPath = "${IMG_LOCATION}/network_logo.png",
                name = "Network Name1",
                originCountry = "US"
            ),
            Network(
                id = 234,
                logoPath = "${IMG_LOCATION}/network_logo.png",
                name = "Network Name2",
                originCountry = "UK"
            )
        ),
        numberOfEpisodes = 10,
        numberOfSeasons = 2,
        originCountry = listOf("US"),
        originalLanguage = "en",
        originalName = "Original Name",
        overview = "Series Overview",
        popularity = 7.8,
        posterPath = "${IMG_LOCATION}/poster.jpg",
        productionCompanies = listOf(
            ProductionCompany(
                id = 1,
                logoPath = "$IMG_LOCATION/logo.png",
                name = "Company A",
                originCountry = "US"
            ),
            ProductionCompany(
                id = 2,
                logoPath = "$IMG_LOCATION/logo2.png",
                name = "Company B",
                originCountry = "UK"
            )
        ),
        productionCountries = listOf(
            ProductionCountry(
                iso31661 = "US",
                name = "United States"
            ),
            ProductionCountry(
                iso31661 = "UK",
                name = "United Kingdom"
            )
        ),
        seasons = listOf(
            Season(
                airDate = "2022-01-01",
                episodeCount = 10,
                id = 456,
                name = "Season Name1",
                overview = "Season Overview",
                posterPath = "${IMG_LOCATION}/season_poster.png",
                seasonNumber = 1
            ),
            Season(
                airDate = "2022-02-01",
                episodeCount = 10,
                id = 567,
                name = "Season Name2",
                overview = "Season Overview",
                posterPath = "${IMG_LOCATION}/season_poster.png",
                seasonNumber = 2
            )
        ),
        spokenLanguages = listOf(
            SpokenLanguage(
                englishName = "English",
                iso6391 = "en",
                name = "English"
            ),
            SpokenLanguage(
                englishName = "French",
                iso6391 = "fr",
                name = "Français"
            )
        ),
        status = "Status",
        tagline = "Tagline",
        type = "Type",
        voteAverage = 8.5,
        voteCount = 100
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.adult, converted.adult)
        assertEquals(fakeModel.backdropPath, converted.backdropPath)
        assertEquals(fakeModel.createdBy, converted.createdBy)
        assertEquals(fakeModel.episodeRunTime, converted.episodeRunTime)
        assertEquals(fakeModel.firstAirDate, converted.firstAirDate)
        assertEquals(fakeModel.genres, converted.genres)
        assertEquals(fakeModel.homepage, converted.homepage)
        assertEquals(fakeModel.id, converted.id)
        assertEquals(fakeModel.inProduction, converted.inProduction)
        assertEquals(fakeModel.languages, converted.languages)
        assertEquals(fakeModel.lastAirDate, converted.lastAirDate)
        assertEquals(fakeModel.episodeToAir, converted.episodeToAir)
        assertEquals(fakeModel.name, converted.name)
        assertEquals(fakeModel.nextEpisodeToAir, converted.nextEpisodeToAir)
        assertEquals(fakeModel.networks, converted.networks)
        assertEquals(fakeModel.numberOfEpisodes, converted.numberOfEpisodes)
        assertEquals(fakeModel.numberOfSeasons, converted.numberOfSeasons)
        assertEquals(fakeModel.originCountry, converted.originCountry)
        assertEquals(fakeModel.originalLanguage, converted.originalLanguage)
        assertEquals(fakeModel.originalName, converted.originalName)
        assertEquals(fakeModel.overview, converted.overview)
        assertEquals(fakeModel.popularity, converted.popularity)
        assertEquals(fakeModel.posterPath, converted.posterPath)
        assertEquals(fakeModel.productionCompanies, converted.productionCompanies)
        assertEquals(fakeModel.productionCountries, converted.productionCountries)
        assertEquals(fakeModel.seasons, converted.seasons)
        assertEquals(fakeModel.spokenLanguages, converted.spokenLanguages)
        assertEquals(fakeModel.status, converted.status)
        assertEquals(fakeModel.tagline, converted.tagline)
        assertEquals(fakeModel.type, converted.type)
        assertEquals(fakeModel.voteAverage, converted.voteAverage)
        assertEquals(fakeModel.voteCount, converted.voteCount)
    }
}
