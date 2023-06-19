package org.hxl.network.mapper.cinema.series

import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.series.SeriesListItem
import org.hxl.network.model.cinema.series.SeriesListItemDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SeriesListItemDTOMapperTest {
    private val fakeDTO = SeriesListItemDTO(
        backdropPath = "backdrop.png",
        firstAirDate = "2022-01-01",
        genreIds = listOf(1, 2, 3),
        id = 123,
        name = "Series Name",
        originCountry = listOf("US"),
        originalLanguage = "en",
        originalName = "Original Name",
        overview = "Series overview",
        popularity = 7.8,
        posterPath = "poster.png",
        voteAverage = 8.5,
        voteCount = 1000
    )

    private val fakeModel = SeriesListItem(
        backdropPath = "IMG_LOCATION/backdrop.png",
        firstAirDate = "2022-01-01",
        genreIds = listOf(1, 2, 3),
        id = 123,
        name = "Series Name",
        originCountry = listOf("US"),
        originalLanguage = "en",
        originalName = "Original Name",
        overview = "Series overview",
        popularity = 7.8,
        posterPath = "IMG_LOCATION/poster.png",
        voteAverage = 8.5,
        voteCount = 1000
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.backdropPath, converted.backdropPath)
        assertEquals(fakeModel.firstAirDate, converted.firstAirDate)
        assertEquals(fakeModel.genreIds, converted.genreIds)
        assertEquals(fakeModel.id, converted.id)
        assertEquals(fakeModel.name, converted.name)
        assertEquals(fakeModel.originCountry, converted.originCountry)
        assertEquals(fakeModel.originalLanguage, converted.originalLanguage)
        assertEquals(fakeModel.originalName, converted.originalName)
        assertEquals(fakeModel.overview, converted.overview)
        assertEquals(fakeModel.popularity, converted.popularity)
        assertEquals(fakeModel.posterPath, converted.posterPath)
        assertEquals(fakeModel.voteAverage, converted.voteAverage)
        assertEquals(fakeModel.voteCount, converted.voteCount)
    }
}