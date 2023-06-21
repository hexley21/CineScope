package org.hxl.cinema.list

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.hxl.cinema.list.movie.MovieListFragment
import org.hxl.cinema.list.series.SeriesListFragment


class CinemaPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position % 2) {
            0 -> MovieListFragment()
            else -> SeriesListFragment()
        }
    }
}