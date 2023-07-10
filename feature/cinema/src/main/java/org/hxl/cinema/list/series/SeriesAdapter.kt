package org.hxl.cinema.list.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.bumptech.glide.RequestManager
import org.hxl.cinema.databinding.ItemCinemaGridBinding
import org.hxl.cinema.list.base.BaseCinemaAdapter
import org.hxl.common.base.BaseViewHolder
import org.hxl.common.callback.SeriesListItemCallback
import org.hxl.model.cinema.series.SeriesListItem

class SeriesAdapter(
    requestManager: RequestManager,
    slidingPaneLayout: SlidingPaneLayout,
    setCinemaId: (id: SeriesListItem) -> Unit,
): BaseCinemaAdapter<SeriesListItem, SeriesAdapter.SeriesListViewHolder>(requestManager, slidingPaneLayout, setCinemaId, SeriesListItemCallback) {
    override fun getCinema(position: Int): SeriesListItem {
        return getItem(position)!!
    }

    override fun getViewHolder(parent: ViewGroup?, viewType: Int): SeriesListViewHolder {
        val binding = ItemCinemaGridBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return SeriesListViewHolder(binding)
    }

    inner class SeriesListViewHolder(binding: ItemCinemaGridBinding):
        BaseViewHolder<ItemCinemaGridBinding, SeriesListItem>(binding) {
        override fun accept(t: SeriesListItem) {
            binding.cinemaName = t.name
            requestManager.load(t.posterPath).into(binding.imgCinemaListPoster)
        }
    }

}