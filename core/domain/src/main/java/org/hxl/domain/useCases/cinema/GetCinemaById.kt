package org.hxl.domain.useCases.cinema

interface GetCinemaById<T> {
    suspend fun details(id: Int, language: String): T
}