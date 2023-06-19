package org.hxl.network.mapper.cinema

import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.MultiSearch
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.MultiSearchDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MultiSearchDTOMapperTest {

    private val fakeDTO = MultiSearchDTO(
        adult = true,
        backdropPath = "/backdrop.jpg",
        id = 123,
        name = "Item Name",
        originalLanguage = "en",
        originalName = "Original Name",
        overview = "Item Overview",
        posterPath = "/poster.jpg",
        mediaType = "movie",
        genreIds = listOf(1, 2, 3),
        popularity = 7.8,
        firstAirDate = "2022-01-01",
        voteAverage = 8.5,
        voteCount = 100,
        originCountry = listOf("US", "UK"),
        title = "Movie Title",
        originalTitle = "Original Title",
        releaseDate = "2022-02-01",
        video = false
    )

    private val fakeModel = MultiSearch(
        adult = true,
        backdropPath = "${IMG_LOCATION}/backdrop.jpg",
        id = 123,
        name = "Item Name",
        originalLanguage = "en",
        originalName = "Original Name",
        overview = "Item Overview",
        posterPath = "${IMG_LOCATION}/poster.jpg",
        mediaType = "movie",
        genreIds = listOf(1, 2, 3),
        popularity = 7.8,
        firstAirDate = "2022-01-01",
        voteAverage = 8.5,
        voteCount = 100,
        originCountry = listOf("US", "UK"),
        title = "Movie Title",
        originalTitle = "Original Title",
        releaseDate = "2022-02-01",
        video = false
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.adult, converted.adult)
        assertEquals(fakeModel.backdropPath, converted.backdropPath)
        assertEquals(fakeModel.id, converted.id)
        assertEquals(fakeModel.name, converted.name)
        assertEquals(fakeModel.originalLanguage, converted.originalLanguage)
        assertEquals(fakeModel.originalName, converted.originalName)
        assertEquals(fakeModel.overview, converted.overview)
        assertEquals(fakeModel.posterPath, converted.posterPath)
        assertEquals(fakeModel.mediaType, converted.mediaType)
        assertEquals(fakeModel.genreIds, converted.genreIds)
        assertEquals(fakeModel.popularity, converted.popularity)
        assertEquals(fakeModel.firstAirDate, converted.firstAirDate)
        assertEquals(fakeModel.voteAverage, converted.voteAverage)
        assertEquals(fakeModel.voteCount, converted.voteCount)
        assertEquals(fakeModel.originCountry, converted.originCountry)
        assertEquals(fakeModel.title, converted.title)
        assertEquals(fakeModel.originalTitle, converted.originalTitle)
        assertEquals(fakeModel.releaseDate, converted.releaseDate)
        assertEquals(fakeModel.video, converted.video)
    }
}