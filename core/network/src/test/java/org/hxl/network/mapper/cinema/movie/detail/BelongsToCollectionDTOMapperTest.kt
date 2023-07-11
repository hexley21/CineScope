package org.hxl.network.mapper.cinema.movie.detail

import org.hxl.model.cinema.detail.BelongsToCollection
import org.hxl.network.mapper.MapperConstants
import org.hxl.network.model.cinema.movie.detail.BelongsToCollectionDTO
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BelongsToCollectionDTOMapperTest {
    private val fakeDto = BelongsToCollectionDTO(
        1,
        "name",
        "poster.png",
        "backdrop.png"
    )

    private val expected = BelongsToCollection(
        1,
        "name",
        "${MapperConstants.IMG_LOCATION}/poster.png",
        "${MapperConstants.IMG_LOCATION}/backdrop.png"
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDto.mapToModel()
        // Assert
        assertEquals(expected.id, converted.id)
        assertEquals(expected.name, converted.name)
        assertEquals(expected.posterPath, converted.posterPath)
        assertEquals(expected.backdropPath, converted.backdropPath)
    }
}
