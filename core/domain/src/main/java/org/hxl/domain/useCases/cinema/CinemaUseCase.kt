package org.hxl.domain.useCases.cinema

interface CinemaUseCase<T: Any> {
    suspend fun getPopular(language: String, page: Int): List<T>
    suspend fun getTop(language: String, page: Int): List<T>
}