package com.hayde117.pagingdemo.data.repository

import androidx.paging.PagingData
import com.hayde117.pagingdemo.model.UnsplashImage
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllImages(): Flow<PagingData<UnsplashImage>>

    fun searchImages(query: String): Flow<PagingData<UnsplashImage>>
}