package org.hxl.domain.useCases.cinema.series

import org.hxl.domain.repository.CinemaRepository
import org.hxl.model.cinema.series.SeriesDetails

class GetSeriesById(private val repository: CinemaRepository) {
    suspend fun invoke(id: Int, language: String): SeriesDetails {
        return repository.getSeriesById(id, language)
    }
}