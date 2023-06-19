package org.hxl.network.mapper.cinema.detail

import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.detail.ProductionCompany
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.detail.ProductionCompanyDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProductionCompanyDTOMapperTest {

    private val fakeDTO = ProductionCompanyDTO(
        id = 1,
        logoPath = "/logo.png",
        name = "Company A",
        originCountry = "US"
    )

    private val fakeModel = ProductionCompany(
        id = 1,
        logoPath = "$IMG_LOCATION/logo.png",
        name = "Company A",
        originCountry = "US"
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.id, converted.id)
        assertEquals(fakeModel.logoPath, converted.logoPath)
        assertEquals(fakeModel.name, converted.name)
        assertEquals(fakeModel.originCountry, converted.originCountry)
    }
}