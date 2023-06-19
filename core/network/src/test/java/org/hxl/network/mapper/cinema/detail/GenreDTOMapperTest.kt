package org.hxl.network.mapper.cinema.detail

import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.detail.Genre
import org.hxl.network.model.cinema.detail.GenreDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GenreDTOMapperTest {

    private val fakeDTO = GenreDTO(
        id = 1,
        name = "Action"
    )

    private val fakeModel = Genre(
        id = 1,
        name = "Action"
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.id, converted.id)
        assertEquals(fakeModel.name, converted.name)
    }
}