package org.hxl.cinema.detail.series

import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.cinema.databinding.FragmentSeriesDetailsBinding
import org.hxl.cinema.detail.base.BaseCinemaDetailsFragment
import org.hxl.model.cinema.series.SeriesDetails
import org.koin.androidx.viewmodel.ext.android.viewModel

class SeriesDetailsFragment: BaseCinemaDetailsFragment<SeriesDetails, SeriesDetailsVM, FragmentSeriesDetailsBinding>() {
    override val vm: SeriesDetailsVM by viewModel<SeriesDetailsVM>()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSeriesDetailsBinding {
        return FragmentSeriesDetailsBinding.inflate(inflater, container, false)
    }
}