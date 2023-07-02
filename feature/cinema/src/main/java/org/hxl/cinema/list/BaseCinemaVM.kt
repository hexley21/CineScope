package org.hxl.cinema.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import kotlinx.coroutines.runBlocking
import org.hxl.domain.useCases.cinema.CinemaUseCase
import org.hxl.domain.useCases.prefs.CinemaResultUseCase
import org.hxl.model.CinemaResultConstants.POPULARITY

abstract class BaseCinemaVM<T: Any>(
    private val cinemaUseCase: CinemaUseCase<T>,
    private val resultUseCase: CinemaResultUseCase
): ViewModel() {

    private lateinit var getList: suspend (page: Int) -> List<T>

    init {
        runBlocking {
            when(resultUseCase.get()) {
                POPULARITY -> setFetchByPopular()
                else -> setFetchByTop()
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