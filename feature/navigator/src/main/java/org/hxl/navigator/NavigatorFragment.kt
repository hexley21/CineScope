package org.hxl.navigator

import android.view.LayoutInflater
import android.view.ViewGroup
import org.hxl.common.base.BaseFragment
import org.hxl.navigator.databinding.FragmentNavigatorBinding

class NavigatorFragment: BaseFragment<FragmentNavigatorBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNavigatorBinding {
        return FragmentNavigatorBinding.inflate(inflater, container, false)
    }


}