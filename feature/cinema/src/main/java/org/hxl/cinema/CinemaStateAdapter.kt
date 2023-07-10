package org.hxl.cinema

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.hxl.cinema.list.movie.MovieFragment
import org.hxl.cinema.list.series.SeriesFragment


class CinemaStateAdapter(
    fragment: CinemaFragment,
): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position % 2) {
            0 -> MovieFragment()
            else -> SeriesFragment()
        }
    }
}