package org.hxl.cinema.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CinemaDetailsVM: ViewModel() {

    val cinemaId = MutableLiveData<Int?>(null)


    fun send(event: CinemaDetailsEvent) {
        when(event) {
            is CinemaDetailsEvent.SetCinemaId -> {
                cinemaId.postValue(event.id)
            }
        }
    }
}