package org.hxl.network.mapper.cinema.movie


import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.detail.BelongsToCollection
import org.hxl.model.cinema.detail.Genre
import org.hxl.model.cinema.detail.ProductionCompany
import org.hxl.model.cinema.detail.ProductionCountry
import org.hxl.model.cinema.detail.SpokenLanguage
import org.hxl.model.cinema.movie.MovieDetails
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.detail.GenreDTO
import org.hxl.network.model.cinema.detail.ProductionCompanyDTO
import org.hxl.network.model.cinema.detail.ProductionCountryDTO
import org.hxl.network.model.cinema.detail.SpokenLanguageDTO
import org.hxl.network.model.cinema.movie.MovieDetailsDTO
import org.hxl.network.model.cinema.movie.detail.BelongsToCollectionDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MovieDetailsDTOMapperTest {

    private val fakeDTO = MovieDetailsDTO(
        adult = true,
        backdropPath = "/backdrop.png",
        belongsToCollection = BelongsToCollectionDTO(
            1,
            "name",
            "poster.png",
            "backdrop.png"
        ),
        budget = 1000000,
        genres = listOf(
            GenreDTO(id = 1, name = "Action"),
            GenreDTO(id = 2, name = "Adventure")
        ),
        homepage = "https://example.com",
        id = 123,
        imdbId = "tt1234567",
        originalLanguage = "en",
        originalTitle = "Original Title",
        overview = "Movie overview",
        popularity = 7.8,
        posterPath = "/poster.png",
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
        releaseDate = "2022-01-01",
        revenue = 5000000,
        runtime = 120,
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
        status = "Released",
        tagline = "Movie tagline",
        title = "Movie Title",
        video = false,
        voteAverage = 8.5,
        voteCount = 1000
    )

    private val fakeModel = MovieDetails(
        adult = true,
        backdropPath = "${IMG_LOCATION}/backdrop.png",
        belongsToCollection = BelongsToCollection(
            1,
            "name",
            "${IMG_LOCATION}/poster.png",
            "${IMG_LOCATION}/backdrop.png"
        ),
        budget = 1000000,
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
        id = 123,
        imdbId = "tt1234567",
        originalLanguage = "en",
        originalTitle = "Original Title",
        overview = "Movie overview",
        popularity = 7.8,
        posterPath = "${IMG_LOCATION}/poster.png",
        productionCompanies = listOf(
            ProductionCompany(
                id = 1,
                logoPath = "${IMG_LOCATION}/logo.png",
                name = "Company A",
                originCountry = "US"
            ),
            ProductionCompany(
                id = 2,
                logoPath = "${IMG_LOCATION}/logo2.png",
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
        releaseDate = "2022-01-01",
        revenue = 5000000,
        runtime = 120,
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
        status = "Released",
        tagline = "Movie tagline",
        title = "Movie Title",
        video = false,
        voteAverage = 8.5,
        voteCount = 1000
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.adult, converted.adult)
        assertEquals(fakeModel.backdropPath, converted.backdropPath)
        assertEquals(fakeModel.belongsToCollection, converted.belongsToCollection)
        assertEquals(fakeModel.budget, converted.budget)
        assertEquals(fakeModel.genres, converted.genres)
        assertEquals(fakeModel.homepage, converted.homepage)
        assertEquals(fakeModel.id, converted.id)
        assertEquals(fakeModel.imdbId, converted.imdbId)
        assertEquals(fakeModel.originalLanguage, converted.originalLanguage)
        assertEquals(fakeModel.originalTitle, converted.originalTitle)
        assertEquals(fakeModel.overview, converted.overview)
        assertEquals(fakeModel.popularity, converted.popularity)
        assertEquals(fakeModel.posterPath, converted.posterPath)
        assertEquals(fakeModel.productionCompanies, converted.productionCompanies)
        assertEquals(fakeModel.productionCountries, converted.productionCountries)
        assertEquals(fakeModel.releaseDate, converted.releaseDate)
        assertEquals(fakeModel.revenue, converted.revenue)
        assertEquals(fakeModel.runtime, converted.runtime)
        assertEquals(fakeModel.spokenLanguages, converted.spokenLanguages)
        assertEquals(fakeModel.status, converted.status)
        assertEquals(fakeModel.tagline, converted.tagline)
        assertEquals(fakeModel.title, converted.title)
        assertEquals(fakeModel.video, converted.video)
        assertEquals(fakeModel.voteAverage, converted.voteAverage)
        assertEquals(fakeModel.voteCount, converted.voteCount)
    }
}