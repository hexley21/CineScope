package org.hxl.cinema.dialog

sealed class CinemaResultEvent {
    object GetCinemaResult: CinemaResultEvent()
    class SetCinemaResult(val result: Int): CinemaResultEvent()
}