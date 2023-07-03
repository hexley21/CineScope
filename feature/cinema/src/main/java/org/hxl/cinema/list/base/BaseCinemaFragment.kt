package org.hxl.cinema.list.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.bumptech.glide.RequestManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.hxl.cinema.databinding.FragmentCinemaListBinding
import org.hxl.cinema.list.CinemaEvent
import org.hxl.common.base.BaseFragmentVM
import org.hxl.common.base.BasePagingAdapter
import org.koin.android.ext.android.inject
import java.net.UnknownHostException

abstract class BaseCinemaFragment<T: Any, VM: BaseCinemaVM<T>>: BaseFragmentVM<FragmentCinemaListBinding, VM>() {
    companion object {
        private const val TAG = "CinemaListFragment"
    }
    protected val requestManager: RequestManager by inject()
    protected lateinit var listAdapter: BasePagingAdapter<T, *>

    override fun beforeCreatingView(savedInstanceState: Bundle?) {
        super.beforeCreatingView(savedInstanceState)
        vm.result.observe(viewLifecycleOwner) {
            vm.send(CinemaEvent.LoadResult(it)) { listAdapter.refresh() }
        }

        lifecycleScope.launch {
            vm.cinemaFlow.collectLatest {
                listAdapter.submitData(it)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCinemaList.adapter = listAdapter

        listAdapter.addLoadStateListener{
            if (it.refresh is LoadState.Loading) {
//                    EspressoIdlingResource.increment();
            }
            else if (it.refresh is LoadState.NotLoading) {

                hideError()
                hideLoading()
//                    EspressoIdlingResource.decrement();
            } else if (it.refresh is LoadState.Error) {
                val throwable = (it.refresh as LoadState.Error).error
                showError((it.refresh as LoadState.Error).error)
                Log.e(TAG, "onViewCreated: ${throwable.message}", throwable)
                hideLoading()
            }
        }

        binding.srlCinemaList.setOnRefreshListener(this::refresh)

        binding.floatingActionButton.setOnClickListener {
            binding.rvCinemaList.smoothScrollToPosition(0)
        }
    }

    private fun refresh() {
        binding.srlCinemaList.isRefreshing = true
        listAdapter.refresh()
    }

    private fun hideError() {
        binding.imgError.visibility = View.GONE
        binding.tvError.visibility = View.GONE
        binding.srlCinemaList.isRefreshing = false
    }

    private fun showError(e: Throwable) {
        if (listAdapter.itemCount == 0) {
            if (e is UnknownHostException) {
                binding.error = Exception("No internet connection…")
            } else {
                binding.error = e
            }
            binding.imgError.visibility = View.VISIBLE
            binding.tvError.visibility = View.VISIBLE
        }
        else {
            if (e is UnknownHostException) {
                showSnackBar("No internet connection…")
            } else {
                showSnackBar(e.message ?: "Something went wrong")
            }
        }
        binding.srlCinemaList.isRefreshing = false
    }

    private fun hideLoading() {
        binding.srlCinemaList.isRefreshing = false
        binding.loadingCinema.visibility = View.GONE
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCinemaListBinding {
        return FragmentCinemaListBinding.inflate(inflater, container, false)
    }
}