package org.hxl.cinema.list.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.hxl.cinema.list.CinemaEvent
import org.hxl.cinema.list.CinemaPaging
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

    private var exclude = false

    init {
        runBlocking {
            setFetchResult(resultUseCase.get())
        }
    }

    val result = resultUseCase.getFlow().asLiveData(Dispatchers.IO)

    fun send(event: CinemaEvent, callback: () -> Unit) {
        when(event) {
            is CinemaEvent.LoadResult -> {
                if (exclude) {
                    setFetchResult(event.result)
                    callback()
                     Log.d(TAG, "CinemaEvent.LoadResult: ${event.result}")
                }
                exclude = true
            }
        }
    }

    fun send(event: CinemaEvent) {
        send(event) {}
    }

    private fun setFetchResult(result: Int) {
        when(result) {
            TOP -> getList = { page -> cinemaUseCase.getTop("en-US", page) }
            POPULARITY -> getList = { page -> cinemaUseCase.getPopular("en-US", page) }
        }
    }

    val cinemaFlow = Pager(PagingConfig(pageSize = 20)) {
        CinemaPaging(getList)
    }.flow.cachedIn(viewModelScope)

}
