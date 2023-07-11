package org.hxl.network.mapper.cinema.series.detail

import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.series.detail.EpisodeToAir
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.series.detail.EpisodeToAirDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class EpisodeToAirDTOMapperTest {

    private val fakeDTO = EpisodeToAirDTO(
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
    )

    private val fakeModel = EpisodeToAir(
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
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.id, converted.id)
        assertEquals(fakeModel.name, converted.name)
        assertEquals(fakeModel.overview, converted.overview)
        assertEquals(fakeModel.voteAverage, converted.voteAverage)
        assertEquals(fakeModel.voteCount, converted.voteCount)
        assertEquals(fakeModel.airDate, converted.airDate)
        assertEquals(fakeModel.episodeNumber, converted.episodeNumber)
        assertEquals(fakeModel.productionCode, converted.productionCode)
        assertEquals(fakeModel.runtime, converted.runtime)
        assertEquals(fakeModel.seasonNumber, converted.seasonNumber)
        assertEquals(fakeModel.showId, converted.showId)
        assertEquals(fakeModel.stillPath, converted.stillPath)
    }
}