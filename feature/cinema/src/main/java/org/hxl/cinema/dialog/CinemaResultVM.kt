package org.hxl.cinema.dialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.hxl.domain.useCases.prefs.CinemaResultUseCase

class CinemaResultVM(private val cinemaResult: CinemaResultUseCase): ViewModel() {

    val result: MutableLiveData<Int> = MutableLiveData()

    @Suppress("NullSafeMutableLiveData")
    fun send(event: CinemaResultEvent) {
        when(event) {
            is CinemaResultEvent.GetCinemaResult -> viewModelScope.launch {
                result.postValue(cinemaResult.get())
            }
            is CinemaResultEvent.SetCinemaResult -> CoroutineScope(Dispatchers.IO).launch {
                cinemaResult.set(event.result)
            }
        }
    }
}