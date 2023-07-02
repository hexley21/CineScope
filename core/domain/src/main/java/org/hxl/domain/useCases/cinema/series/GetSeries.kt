package org.hxl.domain.useCases.cinema.series

import org.hxl.domain.repository.CinemaRepository
import org.hxl.domain.useCases.cinema.CinemaUseCase
import org.hxl.model.cinema.series.SeriesListItem

class GetSeries(private val repository: CinemaRepository): CinemaUseCase<SeriesListItem> {
    override suspend fun getPopular(language: String, page: Int): List<SeriesListItem> {
        return repository.getPopularSeries(language, page)
    }

    override suspend fun getTop(language: String, page: Int): List<SeriesListItem> {
        return repository.getTopSeries(language, page)
    }
}