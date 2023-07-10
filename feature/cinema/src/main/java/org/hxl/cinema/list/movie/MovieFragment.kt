package org.hxl.cinema.list.movie

import android.os.Bundle
import org.hxl.cinema.R
import org.hxl.cinema.detail.movie.MovieDetailsFragment
import org.hxl.cinema.list.base.BaseCinemaFragment
import org.hxl.model.cinema.movie.MovieListItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment: BaseCinemaFragment<MovieListItem, MovieVM>() {
    override val vm: MovieVM by viewModel<MovieVM>()
    private val movieDetails = MovieDetailsFragment()

    override fun beforeCreatingView(savedInstanceState: Bundle?) {
        listAdapter = MovieAdapter(
            requestManager,
            requireActivity().findViewById(R.id.sliding_pane_layout)
        ) { parentFragment.setCinema(it) }
        super.beforeCreatingView(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        parentFragment.setDetailsStrategy(movieDetails)
    }
}