package org.hxl.cinema.list.search

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
import org.hxl.cinema.databinding.FragmentCinemaSearchBinding
import org.hxl.common.base.BaseFragmentVM
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.net.UnknownHostException

class CinemaSearchFragment: BaseFragmentVM<FragmentCinemaSearchBinding, CinemaSearchVM>() {
    override val vm: CinemaSearchVM by viewModel<CinemaSearchVM>()
    companion object {
        private const val TAG = "CinemaListFragment"
    }
    private val requestManager: RequestManager by inject()
    val listAdapter = CinemaSearchAdapter(requestManager)

    fun send(event: CinemaSearchEvent, callback: () -> Unit) {
        vm.send(event, callback)
    }

    fun send(event: CinemaSearchEvent) {
        vm.send(event)
    }

    override fun beforeCreatingView(savedInstanceState: Bundle?) {
        super.beforeCreatingView(savedInstanceState)

        vm.query.observe(this) {
            if (it.length < 2) {
                binding.rvCinemaSearchList.visibility = View.GONE
            }
            else {
                binding.rvCinemaSearchList.visibility = View.VISIBLE
            }
        }

        lifecycleScope.launch {
            vm.cinemaFlow.collectLatest {
                listAdapter.submitData(it)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCinemaSearchList.adapter = listAdapter

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
    }

    private fun hideError() {
        binding.imgSearchError.visibility = View.GONE
        binding.tvSearchError.visibility = View.GONE
    }

    private fun showError(e: Throwable) {
        if (listAdapter.itemCount == 0) {
            if (e is UnknownHostException) {
                binding.error = Exception("No internet connection…")
            } else {
                binding.error = e
            }
            binding.imgSearchError.visibility = View.VISIBLE
            binding.tvSearchError.visibility = View.VISIBLE
        }
        else {
            if (e is UnknownHostException) {
                showSnackBar("No internet connection…")
            } else {
                showSnackBar(e.message ?: "Something went wrong")
            }
        }
    }

    private fun hideLoading() {
        binding.loadingSearchCinema.visibility = View.GONE
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCinemaSearchBinding {
        return FragmentCinemaSearchBinding.inflate(inflater, container, false)
    }
}