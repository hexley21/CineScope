package org.hxl.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


abstract class BaseFragment<VB : ViewDataBinding> : Fragment() {
    protected lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater, container)
        beforeCreatingView(savedInstanceState)
        return binding.root
    }

    protected fun showSnackBar(message: String) {
        showSnackBar(message, Snackbar.LENGTH_LONG)
    }

    protected fun showSnackBar(message: String, length: Int) {
        Snackbar.make(requireContext(), binding.root, message, length).show()
    }

    protected open fun beforeCreatingView(savedInstanceState: Bundle?) {}

    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

}

