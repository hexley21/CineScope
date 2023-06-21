package org.hxl.common.callback

import androidx.recyclerview.widget.DiffUtil
import org.hxl.model.cinema.movie.MovieListItem

object MovieListItemCallback: DiffUtil.ItemCallback<MovieListItem>() {
    override fun areItemsTheSame(oldItem: MovieListItem, newItem: MovieListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieListItem, newItem: MovieListItem): Boolean {
        return oldItem == newItem
    }
}