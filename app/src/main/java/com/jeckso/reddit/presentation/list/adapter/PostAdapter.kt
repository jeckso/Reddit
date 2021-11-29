package com.jeckso.reddit.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jeckso.reddit.android.adapter.BasePaginationAdapter
import com.jeckso.reddit.android.adapter.OnItemClickListener
import com.jeckso.reddit.databinding.LiPostBinding
import com.jeckso.reddit.presentation.base.dto.PostDiffCallback

class PostAdapter(
    listener: OnItemClickListener<PostVM>
) : BasePaginationAdapter<PostVM, PostVH>(PostDiffCallback, listener) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding = LiPostBinding.inflate(inflater, parent, false)
        return PostVH(viewBinding)
    }

}