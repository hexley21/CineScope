package org.hxl.cinema.list.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.RequestManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.hxl.cinema.databinding.FragmentCinemaListBinding
import org.hxl.common.base.BaseFragmentVM
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment: BaseFragmentVM<FragmentCinemaListBinding, MovieListViewModel>() {
    override val vm: MovieListViewModel by viewModel<MovieListViewModel>()

    private val requestManager: RequestManager by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieListAdapter = MovieListAdapter(requestManager)
        binding.rvCinemaList.adapter = movieListAdapter

        lifecycleScope.launch {
            vm.popularMoviesFlow.collectLatest {
                movieListAdapter.submitData(it)
            }
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCinemaListBinding {
        return FragmentCinemaListBinding.inflate(inflater, container, false)
    }
}