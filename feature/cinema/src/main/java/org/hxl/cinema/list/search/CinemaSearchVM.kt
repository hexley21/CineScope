package org.hxl.cinema.list.search

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

    private var query = ""

    fun send(event: CinemaSearchEvent, callback: () -> Unit) {
        when(event) {
            is CinemaSearchEvent.Search -> {
                query = event.query
            }
        }
        callback()
    }

    fun send(event: CinemaSearchEvent) {
        send(event) {}
    }

    val cinemaFlow = Pager(PagingConfig(pageSize = 20)) {
        CinemaPaging { searchMulti.invoke(query, true, "en-US", it) }
    }.flow.cachedIn(viewModelScope)

}
