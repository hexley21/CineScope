package org.hxl.cinema.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.cinema.databinding.FragmentCinemaDetailsBinding
import org.hxl.common.base.BaseFragment

class CinemaDetailsFragment: BaseFragment<FragmentCinemaDetailsBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCinemaDetailsBinding {
        return FragmentCinemaDetailsBinding.inflate(inflater, container, false)
    }
}