package com.hayde117.pagingdemo.navigation

import kotlinx.serialization.Serializable

sealed class Screen{
    @Serializable
    data object Home: Screen()

    @Serializable
    data object Search: Screen()
}
