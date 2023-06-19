package org.hxl.network.mapper.cinema.series.detail

import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.series.detail.Network
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.series.detail.NetworkDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NetworkDTOMapperTest {

    private val fakeDTO = NetworkDTO(
        id = 123,
        logoPath = "/network_logo.png",
        name = "Network Name",
        originCountry = "US"
    )

    private val fakeModel = Network(
        id = 123,
        logoPath = "${IMG_LOCATION}/network_logo.png",
        name = "Network Name",
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