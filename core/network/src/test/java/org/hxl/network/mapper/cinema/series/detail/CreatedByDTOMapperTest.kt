package org.hxl.network.mapper.cinema.series.detail

import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.series.detail.CreatedBy
import org.hxl.network.model.cinema.series.detail.CreatedByDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CreatedByDTOMapperTest {

    private val fakeDTO = CreatedByDTO(
        id = 123,
        creditId = "abc123",
        name = "John Doe",
        gender = 1,
        profilePath = "profile.png"
    )

    private val fakeModel = CreatedBy(
        id = 123,
        creditId = "abc123",
        name = "John Doe",
        gender = 1,
        profilePath = "profile.png"
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.id, converted.id)
        assertEquals(fakeModel.creditId, converted.creditId)
        assertEquals(fakeModel.name, converted.name)
        assertEquals(fakeModel.gender, converted.gender)
        assertEquals(fakeModel.profilePath, converted.profilePath)
    }
}