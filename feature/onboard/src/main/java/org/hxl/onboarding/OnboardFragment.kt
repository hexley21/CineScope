package org.hxl.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import org.hxl.common.base.BaseFragment
import org.hxl.onboard.databinding.FragmentOnboardBinding

class OnboardFragment: BaseFragment<FragmentOnboardBinding, ViewModel>() {
    override val vm: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentOnboardBinding {
        return FragmentOnboardBinding.inflate(inflater, container, false)
    }

}