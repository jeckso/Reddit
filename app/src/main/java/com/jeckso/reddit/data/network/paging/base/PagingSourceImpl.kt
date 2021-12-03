package com.jeckso.reddit.data.network.paging.base

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jeckso.reddit.data.network.rest.models.TopListResponse

class PagingSourceImpl<T : Any> constructor(
    private val retriever: suspend (String, Int) -> LoadResult.Page<String, T>
) : PagingSource<String, T>() {

    companion object {
        const val DEFAULT_PAGE_INDEX = ""
    }

    private var lastElementId: String = ""

    override suspend fun load(params: LoadParams<String>): LoadResult<String, T> {
        val page = lastElementId ?: " "
        return try {

            val result = retriever(page, params.loadSize)
            lastElementId = result.nextKey?:" "
            return result
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<String, T>): String = DEFAULT_PAGE_INDEX
}