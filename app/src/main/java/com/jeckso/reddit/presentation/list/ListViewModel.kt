package com.jeckso.reddit.presentation.list

import com.jeckso.reddit.data.network.rest.services.PostsService
import com.jeckso.reddit.presentation.base.vm.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val postsService: PostsService
) : BaseViewModel() {

}