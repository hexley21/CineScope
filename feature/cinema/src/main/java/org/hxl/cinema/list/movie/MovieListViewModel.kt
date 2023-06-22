package org.hxl.cinema.list.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import org.hxl.domain.useCases.cinema.movie.GetPopularMovies
import org.hxl.domain.useCases.cinema.movie.GetTopMovies

class MovieListViewModel(
    val getPopularMovies: GetPopularMovies,
    private val getTopMovies: GetTopMovies,
): ViewModel() {
    val popularMoviesFlow = Pager(
        PagingConfig(pageSize = 20)
    ){
        MovieListItemPaging {
            getPopularMovies.invoke("en-US", it)
        }
    }.flow.cachedIn(viewModelScope)

    val topMoviesFlow = Pager(
        PagingConfig(pageSize = 20)
    ){
        MovieListItemPaging {
            getTopMovies.invoke("en-US", it)
        }
    }.flow.cachedIn(viewModelScope)
}