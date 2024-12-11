package com.hayde117.pagingdemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.hayde117.pagingdemo.screens.home.HomeScreen
import com.hayde117.pagingdemo.screens.search.SearchScreen

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home
    ) {
        composable<Screen.Home>{
            HomeScreen(navController = navController)
        }
        composable<Screen.Search>{
            SearchScreen(navController = navController)
        }
    }
}