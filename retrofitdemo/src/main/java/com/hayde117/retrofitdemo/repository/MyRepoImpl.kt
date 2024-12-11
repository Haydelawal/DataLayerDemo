package com.hayde117.retrofitdemo.repository

import com.hayde117.retrofitdemo.data.Api
import com.hayde117.retrofitdemo.model.MyPost
import com.hayde117.retrofitdemo.repository.MyRepo
import retrofit2.Response
import javax.inject.Inject

class MyRepoImpl @Inject constructor(private val api: Api) : MyRepo {

    override suspend fun getPost(): Response<MyPost> {
        return api.getPost()
    }
}