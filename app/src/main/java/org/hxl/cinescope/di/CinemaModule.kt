package org.hxl.cinescope.di

import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import org.hxl.cinema.list.movie.MovieListViewModel
import org.hxl.cinema.list.series.SeriesListViewModel
import org.hxl.cinescope.R
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val cinemaModule = module {
    viewModel<MovieListViewModel> {
        MovieListViewModel(
            getPopularMovies = get(),
            getTopMovies = get(),
        )
    }
    viewModel<SeriesListViewModel> {
        SeriesListViewModel(
            getPopularSeries = get(),
            getTopSeries = get()
        )
    }

    single<RequestManager> {
        Glide.with(androidContext()).setDefaultRequestOptions(
            RequestOptions()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
        )
    }

}
