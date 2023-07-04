package org.hxl.cinema.list.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import org.hxl.cinema.list.CinemaPaging
import org.hxl.domain.useCases.cinema.SearchMulti

class CinemaSearchVM(
    private val searchMulti: SearchMulti
): ViewModel() {
    companion object {
        const val TAG = "CinemaSearchVM"
    }

    val query: MutableLiveData<String> = MutableLiveData()

    init {
        query.postValue("")
    }

    fun send(event: CinemaSearchEvent, callback: () -> Unit) {
        when(event) {
            is CinemaSearchEvent.Search -> {
                query.postValue(event.query)
            }
        }
        callback()
    }

    fun send(event: CinemaSearchEvent) {
        send(event) {}
    }

    val cinemaFlow = Pager(PagingConfig(pageSize = 20)) {
        CinemaPaging { searchMulti.invoke(query.value!!, false, "en-US", it) }
    }.flow.cachedIn(viewModelScope)

}
