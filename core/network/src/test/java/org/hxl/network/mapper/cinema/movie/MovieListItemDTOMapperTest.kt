package org.hxl.network.mapper.cinema.movie

import junit.framework.TestCase.assertEquals
import org.hxl.model.cinema.movie.MovieListItem
import org.hxl.network.mapper.MapperConstants.IMG_LOCATION
import org.hxl.network.model.cinema.movie.MovieListItemDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MovieListItemDTOMapperTest {

    private val fakeDTO = MovieListItemDTO(
        adult = true,
        backdropPath = "/backdrop.png",
        genreIds = listOf(1, 2, 3),
        id = 123,
        originalLanguage = "en",
        originalTitle = "Original Title",
        overview = "Movie overview",
        popularity = 7.8,
        posterPath = "/poster.png",
        releaseDate = "2022-01-01",
        title = "Movie Title",
        video = false,
        voteAverage = 8.5,
        voteCount = 1000
    )

    private val fakeModel = MovieListItem(
        adult = true,
        backdropPath = "${IMG_LOCATION}/backdrop.png",
        genreIds = listOf(1, 2, 3),
        id = 123,
        originalLanguage = "en",
        originalTitle = "Original Title",
        overview = "Movie overview",
        popularity = 7.8,
        posterPath = "${IMG_LOCATION}/poster.png",
        releaseDate = "2022-01-01",
        title = "Movie Title",
        video = false,
        voteAverage = 8.5,
        voteCount = 1000
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.adult, converted.adult)
        assertEquals(fakeModel.backdropPath, converted.backdropPath)
        assertEquals(fakeModel.genreIds, converted.genreIds)
        assertEquals(fakeModel.id, converted.id)
        assertEquals(fakeModel.originalLanguage, converted.originalLanguage)
        assertEquals(fakeModel.originalTitle, converted.originalTitle)
        assertEquals(fakeModel.overview, converted.overview)
        assertEquals(fakeModel.popularity, converted.popularity)
        assertEquals(fakeModel.posterPath, converted.posterPath)
        assertEquals(fakeModel.releaseDate, converted.releaseDate)
        assertEquals(fakeModel.title, converted.title)
        assertEquals(fakeModel.video, converted.video)
        assertEquals(fakeModel.voteAverage, converted.voteAverage)
        assertEquals(fakeModel.voteCount, converted.voteCount)
    }
}