package com.hayde117.roomdemo.navigation

import com.hayde117.roomdemo.data.Person
import kotlinx.serialization.Serializable

sealed class Screens {

    @Serializable
    data object List: Screens()

    @Serializable
    data object Add: Screens()

    @Serializable
    data class Edit(val person: Person): Screens()

    @Serializable
    data object Search: Screens()

}



