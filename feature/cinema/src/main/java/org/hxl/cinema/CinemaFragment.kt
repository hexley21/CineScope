package org.hxl.cinema

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.RequestManager
import com.google.android.material.tabs.TabLayoutMediator
import org.hxl.cinema.databinding.FragmentCinemaBinding
import org.hxl.cinema.detail.base.BaseCinemaDetailsFragment
import org.hxl.cinema.detail.movie.MovieDetailsFragment
import org.hxl.cinema.detail.series.SeriesDetailsFragment
import org.hxl.cinema.dialog.CinemaResultDialog
import org.hxl.cinema.list.base.CinemaOnBackPressed
import org.hxl.cinema.search.CinemaSearchEvent
import org.hxl.cinema.search.CinemaSearchFragment
import org.hxl.common.base.BaseFragmentVM
import org.hxl.model.cinema.MultiSearchItem
import org.hxl.model.cinema.movie.MovieListItem
import org.hxl.model.cinema.series.SeriesListItem
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CinemaFragment: BaseFragmentVM<FragmentCinemaBinding, CinemaViewModel>() {

    private lateinit var detailsStrategy: BaseCinemaDetailsFragment<*, * ,*>
    private val requestManager: RequestManager by inject()
    private val movieDetails = MovieDetailsFragment()
    private val seriesDetails = SeriesDetailsFragment()
    override val vm: CinemaViewModel by viewModel<CinemaViewModel>()

    private fun setDetailsStrategy(detailsStrategy: BaseCinemaDetailsFragment<*, * ,*>) {
        this.detailsStrategy = detailsStrategy
        childFragmentManager.beginTransaction().replace(R.id.detail_container, detailsStrategy).commit()
    }

    private fun setCinema(id: Int?, title: String?, poster: String?) {
        detailsStrategy.setCinema(id!!)
        binding.detailsCollapsingLayout.title = title
        requestManager.load(poster).into(binding.cinemaDetailsPoster)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            CinemaOnBackPressed(binding.slidingPaneLayout)
        )

        binding.cinemaListPager.adapter = CinemaStateAdapter(this)
        binding.cinemaListPager.isUserInputEnabled = false

        binding.cinemaListPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position) {
                    0 -> setMovieStrategy()
                    else -> setSeriesStrategy()
                }
            }
        })

        TabLayoutMediator(binding.cinemaListTabs, binding.cinemaListPager, true, true)
        { tab, position ->
            if (position == 0) tab.setText(requireContext().getString(org.hxl.common.R.string.movies))
            else tab.setText(requireContext().getString(org.hxl.common.R.string.series))
        }.attach()


        val searchFragment: CinemaSearchFragment = binding.fragmentCinemaSearch.getFragment()

        binding.cinemaSearchView.editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                Log.d("CINEMA_FRAGMENT", "onTextChanged: $s")
                searchFragment.send(CinemaSearchEvent.Search(s.toString()))
            }
        })

        val searchClearBtn: ImageButton =
            binding.cinemaSearchView.findViewById(com.google.android.material.R.id.open_search_view_clear_button)
        searchClearBtn.setOnClickListener {
            binding.cinemaSearchView.clearText()
            binding.cinemaSearchView.clearFocusAndHideKeyboard()
        }

        binding.searchBar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.menu_sort -> true
                R.id.menu_trend -> {
                    val dialog = CinemaResultDialog()
                    dialog.show(parentFragmentManager, CinemaResultDialog.TAG)
                    true
                }
                else -> false
            }
        }
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentCinemaBinding {
        return FragmentCinemaBinding.inflate(layoutInflater, container, false)
    }

    fun setMovieStrategy() = setDetailsStrategy(movieDetails)

    fun setSeriesStrategy() = setDetailsStrategy(seriesDetails)

    fun setCinema(movie: MovieListItem) {
        setCinema(movie.id, movie.title, movie.backdropPath?: movie.posterPath)
    }

    fun setCinema(series: SeriesListItem) {
        setCinema(series.id, series.name, series.backdropPath?: series.posterPath)
    }

    fun setCinema(search: MultiSearchItem) {
        setCinema(search.id, search.name ?: search.title, search.profilePath ?: search.backdropPath?: search.posterPath)
    }

}