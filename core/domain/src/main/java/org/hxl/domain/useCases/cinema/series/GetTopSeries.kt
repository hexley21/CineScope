package org.hxl.domain.useCases.cinema.series

import org.hxl.domain.repository.CinemaRepository
import org.hxl.model.cinema.series.SeriesListItem

class GetTopSeries(private val repository: CinemaRepository) {
    suspend fun invoke(language: String, page: Int): List<SeriesListItem> {
        return repository.getTopSeries(language, page)
    }
}