package com.hayde117.retrofitdemo.model

import com.google.gson.annotations.SerializedName

data class MyPost (

    @SerializedName("userId")
    val myUserId: Int,
    val id: Int,
    val title: String,
    val body: String

        )