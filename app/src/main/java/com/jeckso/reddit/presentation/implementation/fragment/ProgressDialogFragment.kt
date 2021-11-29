package com.jeckso.reddit.presentation.implementation.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jeckso.reddit.R
import com.jeckso.reddit.databinding.FragmentProgressBinding
import com.jeckso.reddit.presentation.base.fragment.BaseDialogFragment
import com.jeckso.reddit.presentation.implementation.EmptyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProgressDialogFragment : BaseDialogFragment<FragmentProgressBinding, EmptyViewModel>() {

    companion object {
        const val TAG = "progres.dialog"
    }

    override val viewModel: EmptyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.Theme_Reddit_ProgressDialog)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentProgressBinding {
        return FragmentProgressBinding.inflate(inflater, container, false)
    }
}