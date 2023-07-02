package org.hxl.cinema.list.series

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.RequestManager
import org.hxl.cinema.databinding.CinemaGridItemBinding
import org.hxl.common.base.BasePagingAdapter
import org.hxl.common.base.BaseViewHolder
import org.hxl.common.callback.SeriesListItemCallback
import org.hxl.model.cinema.series.SeriesListItem

class SeriesAdapter(private val requestManager: RequestManager): BasePagingAdapter<SeriesListItem, SeriesAdapter.SeriesListViewHolder>(
    SeriesListItemCallback
) {
     companion object {
         private const val TAG: String = "SeriesListAdapter"
     }

    override fun getViewHolder(parent: ViewGroup?, viewType: Int): SeriesListViewHolder {
        val binding = CinemaGridItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return SeriesListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeriesListViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {
            Log.d(TAG, "onBindViewHolder: ${holder.itemView.findNavController().currentDestination}")
        }
    }

    inner class SeriesListViewHolder(binding: CinemaGridItemBinding):
        BaseViewHolder<CinemaGridItemBinding, SeriesListItem>(binding) {
        override fun accept(t: SeriesListItem) {
            binding.cinemaName = t.name
            requestManager.load(t.posterPath).into(binding.imgCinemaListPoster)
        }
    }


}