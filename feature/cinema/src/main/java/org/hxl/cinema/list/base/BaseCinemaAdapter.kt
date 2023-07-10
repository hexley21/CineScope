package org.hxl.cinema.list.base

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.bumptech.glide.RequestManager
import org.hxl.common.base.BasePagingAdapter
import org.hxl.common.base.BaseViewHolder

abstract class BaseCinemaAdapter<T: Any, VH: BaseViewHolder<*, T>>(
    protected val requestManager: RequestManager,
    private val slidingPaneLayout: SlidingPaneLayout,
    private val setCinemaId: (cinema: T) -> Unit,
    itemCallback: ItemCallback<T>
) : BasePagingAdapter<T, VH>(itemCallback) {

    abstract fun getCinema(position: Int): T

    override fun onBindViewHolder(holder: VH, position: Int) {
        super.onBindViewHolder(holder, position)
        val cinema = getCinema(position)
        if (position == 0) {
            setCinemaId(cinema)
        }
        holder.itemView.setOnClickListener {
            setCinemaId(cinema)
            slidingPaneLayout.openPane()
        }
    }

}