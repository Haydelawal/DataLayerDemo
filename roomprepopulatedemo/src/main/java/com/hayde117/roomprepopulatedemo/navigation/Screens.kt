package com.hayde117.roomprepopulatedemo.navigation

import kotlinx.serialization.Serializable

sealed class Screens {

    @Serializable
    data object List: Screens()
}



