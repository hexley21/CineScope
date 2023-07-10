package org.hxl.cinema.detail.base

import androidx.databinding.ViewDataBinding
import org.hxl.cinema.detail.CinemaDetailsEvent
import org.hxl.common.base.BaseFragmentVM

abstract class BaseCinemaDetailsFragment<T: Any, VM: BaseCinemaDetailsVM<T>, VB: ViewDataBinding>: BaseFragmentVM<VB, VM>() {

    fun setCinema(id: Int) {
        vm.send(CinemaDetailsEvent.SetCinemaId(id))
    }
}