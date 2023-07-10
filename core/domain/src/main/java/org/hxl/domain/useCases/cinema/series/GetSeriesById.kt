package org.hxl.domain.useCases.cinema.series

import org.hxl.domain.repository.CinemaRepository
import org.hxl.domain.useCases.cinema.GetCinemaById
import org.hxl.model.cinema.series.SeriesDetails

class GetSeriesById(private val repository: CinemaRepository): GetCinemaById<SeriesDetails> {
    override suspend fun details(id: Int, language: String): SeriesDetails {
        return repository.getSeriesById(id, language)
    }
}