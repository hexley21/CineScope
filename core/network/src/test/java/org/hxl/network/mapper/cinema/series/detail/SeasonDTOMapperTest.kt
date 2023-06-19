package org.hxl.network.mapper.cinema.series.detail

import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.series.detail.Season
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.series.detail.SeasonDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SeasonDTOMapperTest {

    private val fakeDTO = SeasonDTO(
        airDate = "2022-01-01",
        episodeCount = 10,
        id = 456,
        name = "Season Name",
        overview = "Season Overview",
        posterPath = "/season_poster.png",
        seasonNumber = 2
    )

    private val fakeModel = Season(
        airDate = "2022-01-01",
        episodeCount = 10,
        id = 456,
        name = "Season Name",
        overview = "Season Overview",
        posterPath = "${IMG_LOCATION}/season_poster.png",
        seasonNumber = 2
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.airDate, converted.airDate)
        assertEquals(fakeModel.episodeCount, converted.episodeCount)
        assertEquals(fakeModel.id, converted.id)
        assertEquals(fakeModel.name, converted.name)
        assertEquals(fakeModel.overview, converted.overview)
        assertEquals(fakeModel.posterPath, converted.posterPath)
        assertEquals(fakeModel.seasonNumber, converted.seasonNumber)
    }
}


