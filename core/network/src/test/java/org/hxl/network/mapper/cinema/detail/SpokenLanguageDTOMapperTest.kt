package org.hxl.network.mapper.cinema.detail

import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.detail.SpokenLanguage
import org.hxl.network.model.cinema.detail.SpokenLanguageDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SpokenLanguageDTOMapperTest {

    private val fakeDTO = SpokenLanguageDTO(
        englishName = "English",
        iso6391 = "en",
        name = "English"
    )

    private val fakeModel = SpokenLanguage(
        englishName = "English",
        iso6391 = "en",
        name = "English"
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.englishName, converted.englishName)
        assertEquals(fakeModel.iso6391, converted.iso6391)
        assertEquals(fakeModel.name, converted.name)
    }
}