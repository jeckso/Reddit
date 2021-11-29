package com.jeckso.reddit.presentation.list.adapter

import com.bumptech.glide.Glide
import com.jeckso.reddit.android.adapter.BaseViewHolder
import com.jeckso.reddit.android.adapter.OnItemClickListener
import com.jeckso.reddit.databinding.LiPostBinding

class PostVH(binding: LiPostBinding) : BaseViewHolder<PostVM, LiPostBinding>(binding) {

    override fun bind(item: PostVM, listener: OnItemClickListener<PostVM>?) {
        super.bind(item, listener)
        with(binding) {
            setup(item)
        }
    }

    private fun LiPostBinding.setup(item: PostVM) {
        titleTV.text = item.title
        authorTV.text = item.authorFullName
        Glide.with(thumbIV)
            .load(item.thumbnail)
            .into(thumbIV)
    }

}