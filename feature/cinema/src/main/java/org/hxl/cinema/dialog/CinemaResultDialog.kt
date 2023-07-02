package org.hxl.cinema.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.hxl.cinema.R
import org.hxl.cinema.databinding.DialogCinemaResultBinding
import org.hxl.common.base.BaseDialog
import org.hxl.model.CinemaResultConstants
import org.koin.androidx.viewmodel.ext.android.viewModel

class CinemaResultDialog: BaseDialog<DialogCinemaResultBinding>() {
    companion object {
        const val TAG = "CinemaResultDialog"
    }
    private val vm: CinemaResultVM by viewModel<CinemaResultVM>()
    private var endResult: Int = CinemaResultConstants.POPULARITY

    override fun beforeCreatingView(savedInstanceState: Bundle?) {
        super.beforeCreatingView(savedInstanceState)
        vm.result.observe(this) {
            when(it) {
                CinemaResultConstants.TOP -> binding.cinemaResultTop.isChecked = true
                CinemaResultConstants.POPULARITY -> binding.cinemaResultPopularity.isChecked = true
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cinemaResultBy.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                R.id.cinema_result_top -> endResult = CinemaResultConstants.TOP
                R.id.cinema_result_popularity -> endResult = CinemaResultConstants.POPULARITY
            }
        }

        vm.send(CinemaResultEvent.GetCinemaResult)
    }

    override fun onDestroyView() {
        vm.send(CinemaResultEvent.SetCinemaResult(endResult))
        super.onDestroyView()
    }


    override fun setViewBinding(
        inflater: LayoutInflater?,
        container: ViewGroup?
    ): DialogCinemaResultBinding {
        return DialogCinemaResultBinding.inflate(layoutInflater, container, false)
    }
}