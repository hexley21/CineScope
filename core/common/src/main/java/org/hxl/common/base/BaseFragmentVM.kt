package org.hxl.common.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragmentVM<VB : ViewDataBinding, VM : ViewModel>: BaseFragment<VB>() {
    protected abstract val vm: VM

}