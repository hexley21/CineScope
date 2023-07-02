package org.hxl.cinema.list.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.cinema.databinding.FragmentCinemaListBinding
import org.hxl.cinema.list.BaseCinemaFragment
import org.hxl.model.cinema.movie.MovieListItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment: BaseCinemaFragment<MovieListItem, MovieVM>() {
    override val vm: MovieVM by viewModel<MovieVM>()

    override fun beforeCreatingView(savedInstanceState: Bundle?) {
        super.beforeCreatingView(savedInstanceState)
        listAdapter = MovieAdapter(requestManager)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCinemaListBinding {
        return FragmentCinemaListBinding.inflate(inflater, container, false)
    }
}