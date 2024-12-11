package com.hayde117.retrofitdemo.repository

import com.hayde117.retrofitdemo.model.MyPost
import retrofit2.Response

interface MyRepo{

    suspend fun getPost(): Response<MyPost>

}