package org.hxl.cinema.detail.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.hxl.cinema.detail.CinemaDetailsEvent
import org.hxl.domain.useCases.cinema.GetCinemaById

abstract class BaseCinemaDetailsVM<T: Any>(
    private val getCinemaById: GetCinemaById<T>
): ViewModel() {
    val cinemaDetails = MutableLiveData<T?>(null)

    fun send(event: CinemaDetailsEvent) {
        when(event) {
            is CinemaDetailsEvent.SetCinemaId -> {
                viewModelScope.launch {
                    getCinemaById.details(event.id, "en-US")
                }
            }
        }
    }
}