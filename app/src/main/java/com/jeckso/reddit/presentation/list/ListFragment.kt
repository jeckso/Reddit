package com.jeckso.reddit.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jeckso.reddit.android.adapter.OnItemClickListener
import com.jeckso.reddit.databinding.FragmentListBinding
import com.jeckso.reddit.presentation.base.fragment.BaseFragment
import com.jeckso.reddit.presentation.list.adapter.PostVM

class ListFragment private constructor() : BaseFragment<ListViewModel, FragmentListBinding>(),
    OnItemClickListener<PostVM> {

    companion object {
        const val TAG = "ListFragment"

        fun arguments() = Bundle()

        fun newInstance(arguments: Bundle = Bundle()): ListFragment {
            val fragment = ListFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    override val viewModel: ListViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false)
    }

    override fun onItemClick(item: PostVM, position: Int) {

    }

}