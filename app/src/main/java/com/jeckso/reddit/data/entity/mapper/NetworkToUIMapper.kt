package com.jeckso.reddit.data.entity.mapper

import com.jeckso.reddit.data.network.rest.models.Children
import com.jeckso.reddit.data.network.rest.models.ChildrenData
import com.jeckso.reddit.presentation.list.adapter.PostVM

object NetworkToUIMapper {

    fun map(response: Children): PostVM = with(response.data) {
        PostVM(
            id,
            author,
            createdUtc,
            created,
            score,
            thumbnail,
            title,
            url
        )
    }
}