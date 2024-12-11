package com.hayde117.pagingdemo.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hayde117.pagingdemo.BuildConfig
import com.hayde117.pagingdemo.data.remote.UnsplashApi
import com.hayde117.pagingdemo.model.UnsplashImage
import com.hayde117.pagingdemo.util.Constants.ITEMS_PER_PAGE

class SearchPagingSource(
    private val unsplashApi: UnsplashApi,
    private val query: String
) : PagingSource<Int, UnsplashImage>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashImage> {
        val currentPage = params.key ?: 1
        return try {
            val apiKey = "Client-ID ${BuildConfig.API_KEY}"

            val response = unsplashApi.searchImages(authHeader = apiKey, query = query, perPage = ITEMS_PER_PAGE)
            val endOfPaginationReached = response.images.isEmpty()
            if (response.images.isNotEmpty()) {
                LoadResult.Page(
                    data = response.images,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached) null else currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UnsplashImage>): Int? {
        return state.anchorPosition
    }

}