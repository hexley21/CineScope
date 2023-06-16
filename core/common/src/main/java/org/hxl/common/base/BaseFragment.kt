package org.hxl.common.base

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar


abstract class BaseFragment<VB : ViewDataBinding, VM : ViewModel> : Fragment() {

    protected lateinit var binding: ViewDataBinding
    protected abstract val vm: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater, container)
        beforeCreatingView(savedInstanceState)
        return binding.root;
    }

    protected fun showSnackBar(message: String) {
        showSnackBar(message, Snackbar.LENGTH_LONG)
    }

    protected fun showSnackBar(message: String, length: Int) {
        Snackbar.make(requireContext(), binding.root, message, length).show()
    }

    protected fun beforeCreatingView(savedInstanceState: Bundle?) { }

    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

}

