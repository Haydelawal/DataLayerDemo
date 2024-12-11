package com.hayde117.roomprepopulatedemo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.hayde117.roomprepopulatedemo.screens.list.ListScreen

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.List) {

        composable<Screens.List> {
            ListScreen(
                navController = navController,
            )
        }
    }
}

val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED

