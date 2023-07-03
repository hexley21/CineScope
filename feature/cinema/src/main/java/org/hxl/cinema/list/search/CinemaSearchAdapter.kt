package org.hxl.cinema.list.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.RequestManager
import org.hxl.cinema.databinding.ItemCinemaSearchBinding
import org.hxl.cinema.list.search.CinemaSearchAdapter.CinemaSearchVH
import org.hxl.common.base.BasePagingAdapter
import org.hxl.common.base.BaseViewHolder
import org.hxl.common.callback.CinemaSearchItemCallback
import org.hxl.model.cinema.MultiSearchItem

class CinemaSearchAdapter(
    private val requestManager: RequestManager
) : BasePagingAdapter<MultiSearchItem, CinemaSearchVH>(CinemaSearchItemCallback) {

    companion object {
        private const val TAG: String = "CinemaSearchAdapter"
    }

    override fun getViewHolder(parent: ViewGroup?, viewType: Int): CinemaSearchVH {
        val binding = ItemCinemaSearchBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return CinemaSearchVH(binding)
    }

    override fun onBindViewHolder(holder: CinemaSearchVH, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {
            Log.d(TAG, "onBindViewHolder: ${holder.itemView.findNavController().currentDestination}")
        }
    }

    inner class CinemaSearchVH(binding: ItemCinemaSearchBinding) :
        BaseViewHolder<ItemCinemaSearchBinding, MultiSearchItem>(binding) {
        override fun accept(t: MultiSearchItem) {
            binding.cinemaName = t.name
            binding.cinemaYear = t.releaseDate
            requestManager.load(t.posterPath).into(binding.imgCinemaListPoster)

        }
    }
}