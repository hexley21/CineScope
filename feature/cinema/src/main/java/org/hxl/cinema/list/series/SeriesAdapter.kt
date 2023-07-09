package org.hxl.cinema.list.series

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.bumptech.glide.RequestManager
import org.hxl.cinema.databinding.ItemCinemaGridBinding
import org.hxl.common.base.BasePagingAdapter
import org.hxl.common.base.BaseViewHolder
import org.hxl.common.callback.SeriesListItemCallback
import org.hxl.model.cinema.series.SeriesListItem

class SeriesAdapter(
    private val requestManager: RequestManager,
    private val slidingPaneLayout: SlidingPaneLayout
) : BasePagingAdapter<SeriesListItem, SeriesAdapter.SeriesListViewHolder>(SeriesListItemCallback) {
     companion object {
         private const val TAG: String = "SeriesListAdapter"
     }

    override fun getViewHolder(parent: ViewGroup?, viewType: Int): SeriesListViewHolder {
        val binding = ItemCinemaGridBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return SeriesListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeriesListViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {
            slidingPaneLayout.openPane()
            Log.d(TAG, "onBindViewHolder: ${holder.itemView.findNavController().currentDestination}")
        }
    }

    inner class SeriesListViewHolder(binding: ItemCinemaGridBinding):
        BaseViewHolder<ItemCinemaGridBinding, SeriesListItem>(binding) {
        override fun accept(t: SeriesListItem) {
            binding.cinemaName = t.name
            requestManager.load(t.posterPath).into(binding.imgCinemaListPoster)
        }
    }


}