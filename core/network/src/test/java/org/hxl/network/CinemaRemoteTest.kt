package org.hxl.network

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.test.runTest
import org.hxl.model.cinema.MultiSearch
import org.hxl.model.cinema.movie.MovieDetails
import org.hxl.model.cinema.movie.MovieListItem
import org.hxl.model.cinema.series.SeriesDetails
import org.hxl.model.cinema.series.SeriesListItem
import org.hxl.network.api.cinema.CinemaService
import org.hxl.network.model.cinema.ListResponse
import org.hxl.network.model.cinema.MultiSearchDTO
import org.hxl.network.model.cinema.movie.MovieDetailsDTO
import org.hxl.network.model.cinema.movie.MovieListItemDTO
import org.hxl.network.model.cinema.series.SeriesDetailsDTO
import org.hxl.network.model.cinema.series.SeriesListItemDTO
import org.hxl.test.fake.TestConstants.ID
import org.hxl.test.fake.TestConstants.INCLUDE_ADULT
import org.hxl.test.fake.TestConstants.LANGUAGE
import org.hxl.test.fake.TestConstants.PAGES
import org.hxl.test.fake.TestConstants.QUERY
import org.hxl.test.fake.TestConstants.SIZE
import org.hxl.test.fake.cinema.FakeNetworkMovieFactory
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CinemaRemoteTest{

    @Mock
    private lateinit var service: CinemaService

    @InjectMocks
    private lateinit var repository: CinemaRepositoryRemoteImpl

    @Test
    fun `get popular movies by 3 returns valid model`() = runTest {
        // Arrange
        val fakeMovieItems: ListResponse<MovieListItemDTO> = FakeNetworkMovieFactory.getMovieListResponse(SIZE)
        `when`(service.getPopularMovies(anyString(), anyInt(), anyString())).thenReturn(fakeMovieItems)
        // Act
        val movieItems: List<MovieListItem> = repository.getPopularMovies(LANGUAGE, PAGES, LANGUAGE)
        // Assert
        assertNotNull(movieItems)
        assertEquals(SIZE, movieItems.size)
        verify(service).getPopularMovies(anyString(), anyInt(), anyString())
    }

    @Test
    fun `get popular movies by 2 returns valid model`() = runTest {
        // Arrange
        val fakeMovieItems: ListResponse<MovieListItemDTO> = FakeNetworkMovieFactory.getMovieListResponse(SIZE)
        `when`(service.getPopularMovies(anyString(), anyInt())).thenReturn(fakeMovieItems)
        // Act
        val movieItems: List<MovieListItem> = repository.getPopularMovies(LANGUAGE, PAGES)
        // Assert
        assertNotNull(movieItems)
        assertEquals(SIZE, movieItems.size)
        verify(service).getPopularMovies(anyString(), anyInt())
    }

    @Test
    fun `get top movies by 3 returns valid model`() = runTest {
        // Arrange
        val fakeMovieItems: ListResponse<MovieListItemDTO> = FakeNetworkMovieFactory.getMovieListResponse(SIZE)
        `when`(service.getTopMovies(anyString(), anyInt(), anyString())).thenReturn(fakeMovieItems)
        // Act
        val movieItems: List<MovieListItem> = repository.getTopMovies(LANGUAGE, PAGES, LANGUAGE)
        // Assert
        assertNotNull(movieItems)
        assertEquals(SIZE, movieItems.size)
        verify(service).getTopMovies(anyString(), anyInt(), anyString())
    }

    @Test
    fun `get top movies by 2 returns valid model`() = runTest {
        // Arrange
        val fakeMovieItems: ListResponse<MovieListItemDTO> = FakeNetworkMovieFactory.getMovieListResponse(SIZE)
        `when`(service.getTopMovies(anyString(), anyInt())).thenReturn(fakeMovieItems)
        // Act
        val movieItems: List<MovieListItem> = repository.getTopMovies(LANGUAGE, PAGES)
        // Assert
        assertNotNull(movieItems)
        assertEquals(SIZE, movieItems.size)
        verify(service).getTopMovies(anyString(), anyInt())
    }

    @Test
    fun `get movie by id returns valid model`() = runTest {
        // Arrange
        val fakeMovieDetails: MovieDetailsDTO = FakeNetworkMovieFactory.getMovieDetailsDTO(SIZE, SIZE, SIZE, SIZE)
        `when`(service.getMovieById(anyInt(), anyString())).thenReturn(fakeMovieDetails)
        // Act
        val movieDetails: MovieDetails = repository.getMovieById(ID, LANGUAGE)
        // Assert
        assertNotNull(movieDetails)
        assertEquals(SIZE, movieDetails.genres!!.size)
        assertEquals(SIZE, movieDetails.productionCompanies!!.size)
        assertEquals(SIZE, movieDetails.productionCountries!!.size)
        assertEquals(SIZE, movieDetails.spokenLanguages!!.size)
        verify(service).getMovieById(anyInt(), anyString())
    }

    @Test
    fun `get popular series returns valid model`() = runTest {
        // Arrange
        val fakeListResponse: ListResponse<SeriesListItemDTO> = FakeNetworkMovieFactory.getSeriesListResponse(SIZE, SIZE, SIZE)
        `when`(service.getPopularSeries(anyString(), anyInt())).thenReturn(fakeListResponse)
        // Act
        val seriesItems: List<SeriesListItem> = repository.getPopularSeries(anyString(), anyInt())
        // Assert
        assertNotNull(seriesItems)
        assertEquals(SIZE, seriesItems.size)
        verify(service).getPopularSeries(anyString(), anyInt())
    }

    @Test
    fun `get top series returns valid model`() = runTest {
        // Arrange
        val fakeListResponse: ListResponse<SeriesListItemDTO> = FakeNetworkMovieFactory.getSeriesListResponse(SIZE, SIZE, SIZE)
        `when`(service.getTopSeries(anyString(), anyInt())).thenReturn(fakeListResponse)
        // Act
        val seriesItems: List<SeriesListItem> = repository.getTopSeries(anyString(), anyInt())
        // Assert
        assertNotNull(seriesItems)
        assertEquals(SIZE, seriesItems.size)
        verify(service).getTopSeries(anyString(), anyInt())
    }

    @Test
    fun `get series by id returns valid model`() = runTest {
        // Arrange
        val fakeSeriesDetails: SeriesDetailsDTO = FakeNetworkMovieFactory.getSeriesDetailsDTO(
            SIZE, SIZE, SIZE, SIZE, SIZE, SIZE, SIZE, SIZE, SIZE)
        `when`(service.getSeriesById(anyInt(), anyString())).thenReturn(fakeSeriesDetails)
        // Act
        val seriesDetails: SeriesDetails = repository.getSeriesById(ID, LANGUAGE)
        // Assert
        assertNotNull(seriesDetails)
        assertEquals(SIZE, seriesDetails.createdBy!!.size)
        assertEquals(SIZE, seriesDetails.genres!!.size)
        assertEquals(SIZE, seriesDetails.languages!!.size)
        assertEquals(SIZE, seriesDetails.networks!!.size)
        assertEquals(SIZE, seriesDetails.originCountry!!.size)
        assertEquals(SIZE, seriesDetails.productionCompanies!!.size)
        assertEquals(SIZE, seriesDetails.productionCountries!!.size)
        assertEquals(SIZE, seriesDetails.seasons!!.size)
        assertEquals(SIZE, seriesDetails.spokenLanguages!!.size)
        verify(service).getSeriesById(anyInt(), anyString())
    }

    @Test
    fun searchMulti() = runTest {
        // Arrange
        val fakeMultiSearch: ListResponse<MultiSearchDTO> = FakeNetworkMovieFactory.getMultiSearchListResponse(
            SIZE, SIZE, SIZE)
        `when`(service.searchMulti(anyString(), anyBoolean(), anyString(), anyInt())).thenReturn(fakeMultiSearch)
        // Act
        val multiSearch: List<MultiSearch> = repository.searchMulti(QUERY, INCLUDE_ADULT, LANGUAGE, PAGES)
        // Assert
        assertNotNull(multiSearch)
        assertEquals(SIZE, multiSearch.size)
        multiSearch.forEach { assertEquals(SIZE, it.genreIds?.size) }
        multiSearch.forEach { assertEquals(SIZE, it.originCountry?.size) }
        verify(service).searchMulti(anyString(), anyBoolean(), anyString(), anyInt())
    }
}