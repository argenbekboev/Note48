package com.example.note.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.note.presentation.ui.fragments.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseFragment(@LayoutRes layoutId: Int): Fragment(layoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
        setupRequests()
        setupSubscribers()
        setupListener()
    }

    protected open fun initialize() {}
    protected open fun setupRequests() {}
    protected open fun setupSubscribers () {}
    protected open fun setupListener() {}

    protected fun <T> StateFlow<UIState<T>>.collectState(
        onLoading: () -> Unit,
        onError: (message: String) -> Unit,
        OnSuccess: (data: T) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectState.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            onError(it.message)
                        }
                        is UIState.Loading -> {
                            onLoading()
                        }
                        is UIState.Success -> {
                            onSuccess(it.data)
                        }
                    }
                }
            }
        }
    }
}