package org.hxl.network.mapper.cinema.detail

import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.detail.ProductionCountry
import org.hxl.network.model.cinema.detail.ProductionCountryDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProductionCountryDTOMapperTest {

    private val fakeDTO = ProductionCountryDTO(
        iso31661 = "US",
        name = "United States"
    )

    private val fakeModel = ProductionCountry(
        iso31661 = "US",
        name = "United States"
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.iso31661, converted.iso31661)
        assertEquals(fakeModel.name, converted.name)
    }
}