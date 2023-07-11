package org.hxl.cinema.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.bumptech.glide.RequestManager
import org.hxl.cinema.databinding.ItemCinemaSearchBinding
import org.hxl.cinema.search.CinemaSearchAdapter.CinemaSearchVH
import org.hxl.common.base.BasePagingAdapter
import org.hxl.common.base.BaseViewHolder
import org.hxl.common.callback.CinemaSearchItemCallback
import org.hxl.model.CinemaMediaTypeConstants.MOVIES
import org.hxl.model.CinemaMediaTypeConstants.PERSON
import org.hxl.model.CinemaMediaTypeConstants.SERIES
import org.hxl.model.cinema.MultiSearchItem

class CinemaSearchAdapter(
    private val requestManager: RequestManager,
    private val slidingPaneLayout: SlidingPaneLayout,
    private val setCinemaId: (cinema: MultiSearchItem) -> Unit,
    private val setStrategy: (mediaType: String?) -> Unit
) : BasePagingAdapter<MultiSearchItem, CinemaSearchVH>(CinemaSearchItemCallback) {

    private var isIdSet = false;

    override fun getViewHolder(parent: ViewGroup?, viewType: Int): CinemaSearchVH {
        val binding = ItemCinemaSearchBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return CinemaSearchVH(binding)
    }

    override fun onBindViewHolder(holder: CinemaSearchVH, position: Int) {
        super.onBindViewHolder(holder, position)
        val cinema = getItem(position)!!
        if (cinema.mediaType == PERSON)
            return

        if (!isIdSet) {
            setStrategy(cinema.mediaType)
            setCinemaId(cinema)
            isIdSet = true
        }
        holder.itemView.setOnClickListener {
            setStrategy(cinema.mediaType)
            setCinemaId(cinema)
            slidingPaneLayout.openPane()
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
                    PERSON -> binding.imgCinemaListPoster.setBackgroundResource(org.hxl.common.R.drawable.person)
                    MOVIES -> binding.imgCinemaListPoster.setBackgroundResource(org.hxl.common.R.drawable.movie)
                    SERIES -> binding.imgCinemaListPoster.setBackgroundResource(org.hxl.common.R.drawable.show)
                }
            }

        }
    }

    private fun loadImg(img: String, binding: ItemCinemaSearchBinding) {
        requestManager.load(img).into(binding.imgCinemaListPoster)
    }
}