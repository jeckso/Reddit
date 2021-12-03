package com.jeckso.reddit.data.network.paging.base

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import com.jeckso.reddit.data.network.rest.models.Children

const val DEFAULT_PAGE_SIZE = 10

private val PAGING_CONFIG = PagingConfig(pageSize = DEFAULT_PAGE_SIZE, enablePlaceholders = true)


fun <T : Any> pagerSourceOfUnknownTotal(
    block: suspend (String) -> List<T>
): PagingSourceImpl<T> {
    return PagingSourceImpl { page, loadSize ->
        val result = block(page)
        val lastElement = (result.last() as Children).data.name

        val nextKey = if (result.size == 10) {
            lastElement
        } else {
            ""
        }
        PagingSource.LoadResult.Page(result, lastElement, nextKey)
    }
}

fun <T : Any> pagerOf(
    config: PagingConfig = PAGING_CONFIG,
    block: suspend (String) -> List<T>
): Pager<String, T> {
    return Pager(config, "", { pagerSourceOfUnknownTotal(block) })
}

fun <T : Any> pagerOf(
    config: PagingConfig = PAGING_CONFIG,
    pagingSource: PagingSource<String, T>
): Pager<String, T> {
    return Pager(config, "", { pagingSource })
}