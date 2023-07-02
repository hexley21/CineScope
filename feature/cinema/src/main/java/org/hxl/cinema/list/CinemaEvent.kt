package org.hxl.cinema.list

sealed class CinemaEvent {
    class LoadResult(val result: Int): CinemaEvent()
}