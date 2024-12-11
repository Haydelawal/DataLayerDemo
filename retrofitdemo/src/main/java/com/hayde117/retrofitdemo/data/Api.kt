package com.hayde117.retrofitdemo.data

import com.hayde117.retrofitdemo.model.MyPost
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("posts/1")
    suspend fun getPost(): Response<MyPost>

}