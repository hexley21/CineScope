package org.hxl.cinescope.di

import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import org.hxl.cinema.detail.movie.MovieDetailsVM
import org.hxl.cinema.detail.series.SeriesDetailsVM
import org.hxl.cinema.dialog.CinemaResultVM
import org.hxl.cinema.list.movie.MovieVM
import org.hxl.cinema.list.series.SeriesVM
import org.hxl.cinema.search.CinemaSearchVM
import org.hxl.cinescope.R
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val cinemaModule = module {
    viewModel<MovieVM> {
        MovieVM(
            getMovies = get(),
            cinemaResult = get()
        )
    }
    viewModel<SeriesVM> {
        SeriesVM(
            getSeries = get(),
            cinemaResult = get()
        )
    }
    viewModel<CinemaResultVM> {
        CinemaResultVM(
            cinemaResult = get()
        )
    }

    viewModel<CinemaSearchVM> {
        CinemaSearchVM(
            searchMulti = get()
        )
    }

    viewModel<MovieDetailsVM> {
        MovieDetailsVM(
            getMovieById = get()
        )
    }

    viewModel<SeriesDetailsVM> {
        SeriesDetailsVM(
            getSeriesById = get()
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
