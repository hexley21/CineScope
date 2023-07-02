package org.hxl.cinema.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.RequestManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.hxl.cinema.databinding.FragmentCinemaListBinding
import org.hxl.common.base.BaseFragmentVM
import org.hxl.common.base.BasePagingAdapter
import org.koin.android.ext.android.inject

abstract class BaseCinemaFragment<T: Any, VM: BaseCinemaVM<T>>: BaseFragmentVM<FragmentCinemaListBinding, VM>() {
    protected val requestManager: RequestManager by inject()
    protected lateinit var listAdapter: BasePagingAdapter<T, *>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCinemaList.adapter = listAdapter

        lifecycleScope.launch {
            vm.cinemaFlow.collectLatest {
                listAdapter.submitData(it)
            }
        }
    }
}