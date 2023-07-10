package org.hxl.cinema.search

sealed class CinemaSearchEvent {
    class Search(val query: String): CinemaSearchEvent()
}