package org.hxl.cinema.list.base

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.bumptech.glide.RequestManager
import org.hxl.common.base.BasePagingAdapter
import org.hxl.common.base.BaseViewHolder

abstract class BaseCinemaAdapter<T: Any, VH: BaseViewHolder<*, T>>(
    protected val requestManager: RequestManager,
    private val slidingPaneLayout: SlidingPaneLayout,
    private val setCinemaId: (id: Int) -> Unit,
    itemCallback: ItemCallback<T>
) : BasePagingAdapter<T, VH>(itemCallback) {

    abstract fun getCinemaId(position: Int): Int

    override fun onBindViewHolder(holder: VH, position: Int) {
        super.onBindViewHolder(holder, position)
        val cinemaId = getCinemaId(position)
        if (position == 0) {
            setCinemaId(cinemaId)
        }
        holder.itemView.setOnClickListener {
            setCinemaId(cinemaId)
            slidingPaneLayout.openPane()
        }
    }

}