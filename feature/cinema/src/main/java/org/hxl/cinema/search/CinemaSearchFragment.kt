package org.hxl.cinema.search

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
import org.hxl.cinema.CinemaFragment
import org.hxl.cinema.R
import org.hxl.cinema.databinding.FragmentCinemaSearchBinding
import org.hxl.common.base.BaseFragmentVM
import org.hxl.model.CinemaMediaTypeConstants.MOVIES
import org.hxl.model.CinemaMediaTypeConstants.SERIES
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.net.UnknownHostException

class CinemaSearchFragment: BaseFragmentVM<FragmentCinemaSearchBinding, CinemaSearchVM>() {
    companion object {
        private const val TAG = "CinemaListFragment"
    }

    private lateinit var cinemaFragment: CinemaFragment
    private val requestManager: RequestManager by inject()
    private lateinit var listAdapter: CinemaSearchAdapter
    override val vm: CinemaSearchVM by viewModel<CinemaSearchVM>()

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

    private fun showLoading() {
        binding.loadingSearchCinema.visibility = View.VISIBLE
    }


    override fun beforeCreatingView(savedInstanceState: Bundle?) {
        super.beforeCreatingView(savedInstanceState)
        cinemaFragment = requireParentFragment() as CinemaFragment

        listAdapter = CinemaSearchAdapter(
            requestManager,
            requireActivity().findViewById(R.id.sliding_pane_layout),
            { cinemaFragment.setCinema(it) },
            {
                Log.d(TAG, "beforeCreatingView: $it")
                when(it) {
                MOVIES -> {
                    Log.d(TAG, "beforeCreatingView: MOVIES")
                    cinemaFragment.setMovieStrategy()
                }
                SERIES -> {
                    Log.d(TAG, "beforeCreatingView: SERIES")
                    cinemaFragment.setSeriesStrategy()
                }
                }
            })

        lifecycleScope.launch {
            vm.listFlow?.collectLatest {
                binding.rvCinemaSearchList.visibility = View.VISIBLE
                listAdapter.submitData(it)
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCinemaSearchList.adapter = listAdapter

        listAdapter.addLoadStateListener{
            when (it.refresh) {
                is LoadState.Loading -> {
//                    EspressoIdlingResource.increment();
                }

                is LoadState.NotLoading -> {
                    hideError()
                    hideLoading()
//                    EspressoIdlingResource.decrement();
                }

                is LoadState.Error -> {
                    val throwable = (it.refresh as LoadState.Error).error
                    showError((it.refresh as LoadState.Error).error)
                    Log.e(TAG, "onViewCreated: ${throwable.message}", throwable)
                    hideLoading()
                }
            }
        }
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentCinemaSearchBinding {
        return FragmentCinemaSearchBinding.inflate(inflater, container, false)
    }

    fun send(event: CinemaSearchEvent) {
        when(event) {
            is CinemaSearchEvent.Search -> {
                if (event.query.length > 2) {
                    showLoading()
                    binding.rvCinemaSearchList.visibility = View.VISIBLE
                    vm.send(event)
                }
                else binding.rvCinemaSearchList.visibility = View.GONE
            }
        }
    }

}