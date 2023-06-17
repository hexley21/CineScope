package org.hxl.onboarding

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.hxl.common.base.BaseFragment
import org.hxl.onboard.databinding.FragmentOnboardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnboardFragment: BaseFragment<FragmentOnboardBinding, OnboardViewModel>() {
    override val vm: OnboardViewModel by viewModel<OnboardViewModel>()

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