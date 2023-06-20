package org.hxl.navigator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationBarView
import org.hxl.common.base.BaseFragment
import org.hxl.navigator.databinding.FragmentNavigatorBinding


class NavigatorFragment: BaseFragment<FragmentNavigatorBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navigatorItemListener = NavigationBarView.OnItemSelectedListener {
            onMenuItemSelect(it.itemId)
        }
        binding.bottomNavigation?.setOnItemSelectedListener(navigatorItemListener)
        binding.railNavigator?.setOnItemSelectedListener(navigatorItemListener)
        binding.viewNavigator?.setNavigationItemSelectedListener { onMenuItemSelect(it.itemId)}
    }

    private fun NavigatorFragment.findMainNavController() = NavHostFragment.findNavController(this)
    private fun NavigatorFragment.findNavController() = Navigation.findNavController(binding.navigatorContainer)

    private fun onMenuItemSelect(id: Int): Boolean {
        when (id) {
            R.id.menu_cinema -> {
                findNavController().navigate(org.hxl.cinema.R.id.nav_cinema)
                return true
            }
            R.id.menu_favorites -> {
                return false
            }
            R.id.menu_discover -> {
                return false
            }
            R.id.menu_quiz -> {
                return false
            }
            R.id.menu_settings -> {
                return false
            }
        }
        return false
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNavigatorBinding {
        return FragmentNavigatorBinding.inflate(inflater, container, false)
    }

}