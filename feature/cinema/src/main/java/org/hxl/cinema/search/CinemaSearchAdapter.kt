package org.hxl.cinema.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.RequestManager
import org.hxl.cinema.databinding.ItemCinemaSearchBinding
import org.hxl.cinema.search.CinemaSearchAdapter.CinemaSearchVH
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
            binding.cinemaName = if (t.name == null) t.title else t.name
            binding.cinemaYear = if (t.releaseDate == null) t.firstAirDate else t.releaseDate
            if (t.profilePath != null) {
                loadImg(t.profilePath!!, binding)
            }
            else if (t.posterPath != null) {
                loadImg(t.posterPath!!, binding)
            }
            else if (t.backdropPath != null){
                loadImg(t.backdropPath!!, binding)
            }
            else {
                when (t.mediaType) {
                    "person" -> binding.imgCinemaListPoster.setBackgroundResource(org.hxl.common.R.drawable.person)
                    "movie" -> binding.imgCinemaListPoster.setBackgroundResource(org.hxl.common.R.drawable.movie)
                    "tv" -> binding.imgCinemaListPoster.setBackgroundResource(org.hxl.common.R.drawable.show)
                }
            }

        }
    }

    private fun loadImg(img: String, binding: ItemCinemaSearchBinding) {
        requestManager.load(img).into(binding.imgCinemaListPoster)
    }
}