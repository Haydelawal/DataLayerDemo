package com.hayde117.pagingdemo.model

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("links")
    @Embedded
    val userLinks: UserLinks,
    val username: String
)
