package org.hxl.cinema.list.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.cinema.databinding.FragmentCinemaListBinding
import org.hxl.cinema.list.BaseCinemaFragment
import org.hxl.model.cinema.series.SeriesListItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class SeriesFragment: BaseCinemaFragment<SeriesListItem, SeriesVM>() {
    override val vm: SeriesVM by viewModel<SeriesVM>()

    override fun beforeCreatingView(savedInstanceState: Bundle?) {
        super.beforeCreatingView(savedInstanceState)
        listAdapter = SeriesAdapter(requestManager)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCinemaListBinding {
        return FragmentCinemaListBinding.inflate(inflater, container, false)
    }
}