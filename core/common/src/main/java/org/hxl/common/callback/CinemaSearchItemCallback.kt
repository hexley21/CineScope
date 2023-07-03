package org.hxl.common.callback

import androidx.recyclerview.widget.DiffUtil
import org.hxl.model.cinema.MultiSearchItem

object CinemaSearchItemCallback: DiffUtil.ItemCallback<MultiSearchItem>() {
    override fun areItemsTheSame(oldItem: MultiSearchItem, newItem: MultiSearchItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MultiSearchItem, newItem: MultiSearchItem): Boolean {
        return oldItem == newItem
    }
}