package org.hxl.cinema.list.search

sealed class CinemaSearchEvent {
    class Search(val query: String): CinemaSearchEvent()
}