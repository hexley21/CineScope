package org.hxl.common.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


abstract class BaseDialog<VB : ViewBinding> : BottomSheetDialogFragment() {
    protected lateinit var binding: VB
    private var defaultOrientation: Int? = null
    protected abstract fun setViewBinding(inflater: LayoutInflater?, container: ViewGroup?): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = setViewBinding(inflater, container)
        beforeCreatingView(savedInstanceState)
        return binding.root
    }

    protected open fun beforeCreatingView(savedInstanceState: Bundle?) {}
    override fun onResume() {
        super.onResume()
        if (defaultOrientation == null) {
            defaultOrientation = requireActivity().requestedOrientation
        }
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LOCKED
    }

    override fun onPause() {
        super.onPause()
        requireActivity().requestedOrientation = defaultOrientation!!
    }
}

