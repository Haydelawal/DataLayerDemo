package com.hayde117.pagingdemo.data.remote

import com.hayde117.pagingdemo.model.SearchResult
import com.hayde117.pagingdemo.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UnsplashApi {

    @GET("/photos")
    suspend fun getAllImages(
        @Header("Authorization") authHeader: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<UnsplashImage>

    @GET("/search/photos")
    suspend fun searchImages(
        @Header("Authorization") authHeader: String,
        @Query("query") query: String,
        @Query("per_page") perPage: Int
    ): SearchResult

}