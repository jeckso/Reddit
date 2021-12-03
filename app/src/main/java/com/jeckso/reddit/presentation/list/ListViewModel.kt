package com.jeckso.reddit.presentation.list

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.jeckso.reddit.data.entity.mapper.NetworkToUIMapper
import com.jeckso.reddit.data.network.paging.base.pagerOf
import com.jeckso.reddit.data.network.rest.services.PostsService
import com.jeckso.reddit.presentation.base.vm.BaseViewModel
import com.jeckso.reddit.presentation.list.adapter.PostVM
import com.jeckso.reddit.presentation.util.Failure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val postsService: PostsService
) : BaseViewModel() {

    companion object {
        const val DEFAULT_PAGE_SIZE = 10
    }

    private val lastItem = MutableStateFlow("")

    private val postPager = pagerOf {
        postsService.getTopPosts(DEFAULT_PAGE_SIZE, it).data.children
    }

    val items: Flow<PagingData<PostVM>> = postPager.flow
        .map { it.map { NetworkToUIMapper.map(it) } }
        .catch { _errorState.emit(Failure(error = it)) }
        .cachedIn(viewModelScope)
}