package org.hxl.cinema.list.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import org.hxl.cinema.CinemaViewModel
import org.hxl.cinema.databinding.FragmentCinemaListBinding
import org.hxl.common.base.BaseFragmentVM

class SeriesListFragment: BaseFragmentVM<FragmentCinemaListBinding, CinemaViewModel>() {
    override val vm: CinemaViewModel
        get() = ViewModelProvider(requireParentFragment())[CinemaViewModel::class.java]

    override fun beforeCreatingView(savedInstanceState: Bundle?) {
        super.beforeCreatingView(savedInstanceState)
    }
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCinemaListBinding {
        return FragmentCinemaListBinding.inflate(inflater, container, false)
    }
}