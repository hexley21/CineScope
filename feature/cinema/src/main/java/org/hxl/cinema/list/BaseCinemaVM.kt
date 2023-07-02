package org.hxl.cinema.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import org.hxl.domain.useCases.cinema.CinemaUseCase
import org.hxl.domain.useCases.prefs.CinemaResultUseCase
import org.hxl.model.CinemaResultConstants.POPULARITY
import org.hxl.model.CinemaResultConstants.TOP

abstract class BaseCinemaVM<T: Any>(
    private val cinemaUseCase: CinemaUseCase<T>,
    resultUseCase: CinemaResultUseCase
): ViewModel() {
    companion object {
        const val TAG = "CinemaVM"
    }

    private lateinit var getList: suspend (page: Int) -> List<T>

    val result = resultUseCase.getFlow().asLiveData(Dispatchers.IO)

    fun send(event: CinemaEvent) {
        when(event) {
            is CinemaEvent.LoadResult -> {
                when(event.result) {
                    TOP -> setFetchByTop()
                    POPULARITY -> setFetchByPopular()
                }
                Log.d(TAG, "CinemaEvent.LoadResult: ${event.result}")
            }
        }
    }

    private fun setFetchByPopular() {
        getList = { page -> cinemaUseCase.getPopular("en-US", page) }
    }

    private fun setFetchByTop() {
        getList = { page -> cinemaUseCase.getTop("en-US", page) }
    }

    val cinemaFlow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        CinemaPaging {
            getList(it)
        }
    }.flow.cachedIn(viewModelScope)

}
