package org.hxl.cinema.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.withContext
import org.hxl.cinema.list.CinemaPaging
import org.hxl.domain.useCases.cinema.SearchMulti
import org.hxl.model.cinema.MultiSearchItem

class CinemaSearchVM(private val searchMulti: SearchMulti): ViewModel() {
    private var pager: Pager<Int, MultiSearchItem>? = null
    private val searchQuery: MutableStateFlow<String> = MutableStateFlow("")

    var listFlow: Flow<PagingData<MultiSearchItem>>? = null
        get() {
            if (field == null) {
                updateListFlow()
            }
            return field
        }

    private fun createOrGetPager(): Pager<Int, MultiSearchItem> {
        if (pager == null) {
            pager = Pager(
                PagingConfig(
                    pageSize = 10,
                    enablePlaceholders = false
                )
            ) {
                CinemaPaging {
                    withContext(Dispatchers.IO) {
                        searchMulti.invoke(searchQuery.value, false, "en-US", it)
                    }
                }
            }
        }
        return pager!!
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun updateListFlow() {
        listFlow = searchQuery.flatMapLatest {
            createOrGetPager().flow.cachedIn(viewModelScope)
        }
    }

    private fun submitSearch(query: String) {
        searchQuery.value = query
        updateListFlow()
    }

    fun send(event: CinemaSearchEvent) {
        when(event) {
            is CinemaSearchEvent.Search -> {
                submitSearch(event.query)
            }
        }
    }

}
