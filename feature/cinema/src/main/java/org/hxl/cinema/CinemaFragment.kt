package org.hxl.cinema

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import org.hxl.cinema.databinding.FragmentCinemaBinding
import org.hxl.cinema.list.CinemaStateAdapter
import org.hxl.common.base.BaseFragmentVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class CinemaFragment: BaseFragmentVM<FragmentCinemaBinding, CinemaViewModel>() {
    override val vm: CinemaViewModel by viewModel<CinemaViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cinemaListPager.adapter = CinemaStateAdapter(this)
        binding.cinemaListPager.isUserInputEnabled = false

        TabLayoutMediator(
            binding.cinemaListTabs,
            binding.cinemaListPager,
            true,
            true,
            ) { tab, position ->
                if (position == 0) tab.setText(requireContext().getString(org.hxl.common.R.string.movies))
                else tab.setText(requireContext().getString(org.hxl.common.R.string.series))
            }.attach()
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCinemaBinding {
        return FragmentCinemaBinding.inflate(layoutInflater, container, false)
    }
}