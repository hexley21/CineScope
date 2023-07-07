package org.hxl.cinema

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.google.android.material.tabs.TabLayoutMediator
import org.hxl.cinema.databinding.FragmentCinemaBinding
import org.hxl.cinema.dialog.CinemaResultDialog
import org.hxl.cinema.list.search.CinemaSearchEvent
import org.hxl.cinema.list.search.CinemaSearchFragment
import org.hxl.common.base.BaseFragmentVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class CinemaFragment: BaseFragmentVM<FragmentCinemaBinding, CinemaViewModel>() {
    override val vm: CinemaViewModel by viewModel<CinemaViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cinemaListPager.adapter = CinemaStateAdapter(this)
        binding.cinemaListPager.isUserInputEnabled = false

        TabLayoutMediator(
            binding.cinemaListTabs,
            binding.cinemaListPager,
            true,
            true
            ) { tab, position ->
                if (position == 0) tab.setText(requireContext().getString(org.hxl.common.R.string.movies))
                else tab.setText(requireContext().getString(org.hxl.common.R.string.series))
        }.attach()

        val searchFragment: CinemaSearchFragment = binding.fragmentCinemaSearch.getFragment()

        binding.cinemaSearchView.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length > 2) {
                    searchFragment.send(CinemaSearchEvent.Search(s.toString())){ searchFragment.listAdapter.refresh() }
                }
                else {
                    searchFragment.hide()
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })

        val searchClearBtn: ImageButton =
            binding.cinemaSearchView.findViewById(com.google.android.material.R.id.open_search_view_clear_button)
        searchClearBtn.setOnClickListener {
            binding.cinemaSearchView.clearText()
            binding.cinemaSearchView.clearFocusAndHideKeyboard()
        }

        binding.searchBar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.menu_sort -> {
                    true
                }
                R.id.menu_trend -> {
                    val dialog = CinemaResultDialog()
                    dialog.show(parentFragmentManager, CinemaResultDialog.TAG)
                    true
                }

                else -> false
            }
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCinemaBinding {
        return FragmentCinemaBinding.inflate(layoutInflater, container, false)
    }
}