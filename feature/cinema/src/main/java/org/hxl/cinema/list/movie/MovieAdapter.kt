package org.hxl.cinema.list.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.bumptech.glide.RequestManager
import org.hxl.cinema.databinding.ItemCinemaGridBinding
import org.hxl.cinema.list.base.BaseCinemaAdapter
import org.hxl.common.base.BaseViewHolder
import org.hxl.common.callback.MovieListItemCallback
import org.hxl.model.cinema.movie.MovieListItem

class MovieAdapter(
    requestManager: RequestManager,
    slidingPaneLayout: SlidingPaneLayout,
    setCinemaId: (cinema: MovieListItem) -> Unit
): BaseCinemaAdapter<MovieListItem, MovieAdapter.MovieListViewHolder>(requestManager, slidingPaneLayout, setCinemaId, MovieListItemCallback) {
    override fun getCinema(position: Int): MovieListItem {
        return getItem(position)!!
    }

    override fun getViewHolder(parent: ViewGroup?, viewType: Int): MovieListViewHolder {
        val binding = ItemCinemaGridBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return MovieListViewHolder(binding)
    }

    inner class MovieListViewHolder(binding: ItemCinemaGridBinding):
        BaseViewHolder<ItemCinemaGridBinding, MovieListItem>(binding) {
        override fun accept(t: MovieListItem) {
            binding.cinemaName = t.title
            requestManager.load(t.posterPath).into(binding.imgCinemaListPoster)
        }
    }

}