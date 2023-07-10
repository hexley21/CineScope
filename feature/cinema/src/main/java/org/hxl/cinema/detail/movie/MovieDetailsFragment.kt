package org.hxl.cinema.detail.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.cinema.databinding.FragmentMovieDetailsBinding
import org.hxl.cinema.detail.base.BaseCinemaDetailsFragment
import org.hxl.model.cinema.movie.MovieDetails
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment: BaseCinemaDetailsFragment<MovieDetails, MovieDetailsVM, FragmentMovieDetailsBinding>() {
    override val vm: MovieDetailsVM by viewModel<MovieDetailsVM>()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMovieDetailsBinding {
        return FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)
    }
}