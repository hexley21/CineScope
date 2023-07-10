package org.hxl.cinema.list.series

import android.os.Bundle
import org.hxl.cinema.R
import org.hxl.cinema.detail.series.SeriesDetailsFragment
import org.hxl.cinema.list.base.BaseCinemaFragment
import org.hxl.model.cinema.series.SeriesListItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class SeriesFragment: BaseCinemaFragment<SeriesListItem, SeriesVM>() {
    override val vm: SeriesVM by viewModel<SeriesVM>()
    private val seriesDetails = SeriesDetailsFragment()

    override fun beforeCreatingView(savedInstanceState: Bundle?) {
        listAdapter = SeriesAdapter(
            requestManager,
            requireActivity().findViewById(R.id.sliding_pane_layout)
        ) { parentFragment.setCinema(it) }
        super.beforeCreatingView(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        parentFragment.setDetailsStrategy(seriesDetails)
    }

}