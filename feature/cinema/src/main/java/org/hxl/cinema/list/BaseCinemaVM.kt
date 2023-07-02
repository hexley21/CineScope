package org.hxl.cinema.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import org.hxl.domain.useCases.cinema.CinemaUseCase

abstract class BaseCinemaVM<T: Any>(private val useCase: CinemaUseCase<T>, ): ViewModel() {

    private lateinit var getList: suspend (page: Int) -> List<T>

    init {
        setFetchByPopular()
    }

    fun setFetchByPopular() {
        getList = { page -> useCase.getPopular("en-US", page) }
    }

    fun setFetchByTop() {
        getList = { page -> useCase.getTop("en-US", page) }
    }


    val cinemaFlow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        CinemaPaging {
            getList(it)
        }
    }.flow.cachedIn(viewModelScope)

}