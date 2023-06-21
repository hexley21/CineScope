package org.hxl.cinema.list.movie

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.RequestManager
import org.hxl.cinema.databinding.CinemaGridItemBinding
import org.hxl.common.base.BasePagingAdapter
import org.hxl.common.base.BaseViewHolder
import org.hxl.common.callback.MovieListItemCallback
import org.hxl.model.cinema.movie.MovieListItem

class MovieListAdapter(private val requestManager: RequestManager): BasePagingAdapter<MovieListItem, MovieListAdapter.MovieListViewHolder>(
    MovieListItemCallback
) {
     companion object {
         private const val TAG: String = "MovieListAdapter"
     }

    override fun getViewHolder(parent: ViewGroup?, viewType: Int): MovieListViewHolder {
        val binding = CinemaGridItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return MovieListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {
            Log.d(TAG, "onBindViewHolder: ${holder.itemView.findNavController().currentDestination}")
        }
    }

    inner class MovieListViewHolder(binding: CinemaGridItemBinding):
        BaseViewHolder<CinemaGridItemBinding, MovieListItem>(binding) {
        override fun accept(t: MovieListItem) {
            binding.cinemaName = t.title
            requestManager.load(t.posterPath).into(binding.imgCinemaListPoster)
        }
    }


}