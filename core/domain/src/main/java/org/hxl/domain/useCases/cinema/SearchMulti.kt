package org.hxl.domain.useCases.cinema

import org.hxl.domain.repository.CinemaRepository
import org.hxl.model.cinema.MultiSearchItem

class SearchMulti(private val repository: CinemaRepository) {
    suspend fun invoke(query: String, includeAdult: Boolean, language: String, page: Int): List<MultiSearchItem> {
        return repository.searchMulti(query, includeAdult, language, page)
    }
}