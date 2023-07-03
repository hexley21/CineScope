package org.hxl.cinema.list.movie

import android.os.Bundle
import org.hxl.cinema.list.base.BaseCinemaFragment
import org.hxl.model.cinema.movie.MovieListItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment: BaseCinemaFragment<MovieListItem, MovieVM>() {
    override val vm: MovieVM by viewModel<MovieVM>()

    override fun beforeCreatingView(savedInstanceState: Bundle?) {
        listAdapter = MovieAdapter(requestManager)
        super.beforeCreatingView(savedInstanceState)
    }

}