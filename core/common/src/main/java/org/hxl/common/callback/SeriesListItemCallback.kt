package org.hxl.common.callback

import androidx.recyclerview.widget.DiffUtil
import org.hxl.model.cinema.series.SeriesListItem

object SeriesListItemCallback: DiffUtil.ItemCallback<SeriesListItem>() {
    override fun areItemsTheSame(oldItem: SeriesListItem, newItem: SeriesListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SeriesListItem, newItem: SeriesListItem): Boolean {
        return oldItem == newItem
    }
}