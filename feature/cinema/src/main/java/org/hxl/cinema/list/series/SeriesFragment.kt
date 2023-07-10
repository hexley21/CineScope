package org.hxl.cinema.list.series

import android.os.Bundle
import org.hxl.cinema.CinemaFragment
import org.hxl.cinema.R
import org.hxl.cinema.list.base.BaseCinemaFragment
import org.hxl.model.cinema.series.SeriesListItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class SeriesFragment: BaseCinemaFragment<SeriesListItem, SeriesVM>() {
    override val vm: SeriesVM by viewModel<SeriesVM>()

    override fun beforeCreatingView(savedInstanceState: Bundle?) {
        listAdapter = SeriesAdapter(
            requestManager,
            requireActivity().findViewById(R.id.sliding_pane_layout)
        ) { (requireParentFragment() as CinemaFragment).setCinemaId(it) }
        super.beforeCreatingView(savedInstanceState)
    }

}