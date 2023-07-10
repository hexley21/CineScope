package org.hxl.cinema.detail

sealed class CinemaDetailsEvent {
    class SetCinemaId(val id: Int): CinemaDetailsEvent()
}