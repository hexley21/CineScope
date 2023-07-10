package org.hxl.cinema.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.hxl.cinema.databinding.FragmentCinemaDetailsBinding
import org.hxl.common.base.BaseFragmentVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class CinemaDetailsFragment: BaseFragmentVM<FragmentCinemaDetailsBinding, CinemaDetailsVM>() {
    override val vm: CinemaDetailsVM by viewModel<CinemaDetailsVM>()

    fun setCinemaId(id: Int) {
        vm.send(CinemaDetailsEvent.SetCinemaId(id))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.cinemaId.observe(this.viewLifecycleOwner) {
            Log.d("CinemaDetailsFragment", "beforeCreatingView: $it")
            binding.toolbarCinemaDetails.title = it.toString()
            binding.detailsCollapsingLayout.title = it.toString()
        }
    }


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCinemaDetailsBinding {
        return FragmentCinemaDetailsBinding.inflate(inflater, container, false)
    }
}