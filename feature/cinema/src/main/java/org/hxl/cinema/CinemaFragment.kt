package org.hxl.cinema

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.hxl.cinema.databinding.FragmentCinemaBinding
import org.hxl.common.base.BaseFragmentVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class CinemaFragment: BaseFragmentVM<FragmentCinemaBinding, CinemaViewModel>() {
    override val vm: CinemaViewModel by viewModel<CinemaViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCinemaBinding {
        return FragmentCinemaBinding.inflate(layoutInflater, container, false)
    }
}