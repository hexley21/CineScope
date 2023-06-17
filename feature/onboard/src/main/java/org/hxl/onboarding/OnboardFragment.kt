package org.hxl.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hxl.common.base.BaseFragmentVM
import org.hxl.onboard.R
import org.hxl.onboard.databinding.FragmentOnboardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnboardFragment: BaseFragmentVM<FragmentOnboardBinding, OnboardViewModel>() {
    override val vm: OnboardViewModel by viewModel<OnboardViewModel>()

    override fun beforeCreatingView(savedInstanceState: Bundle?) {
        super.beforeCreatingView(savedInstanceState)
        runBlocking {
            if (vm.isSkip()) {
                findNavController().navigate(R.id.onboard_to_navigator)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOnboardContinue.setOnClickListener {
            vm.viewModelScope.launch {
                vm.setSkip(true)
                findNavController().navigate(R.id.onboard_to_navigator)
            }
        }
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentOnboardBinding {
        return FragmentOnboardBinding.inflate(inflater, container, false)
    }

}