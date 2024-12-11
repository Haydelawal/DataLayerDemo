package com.hayde117.roomdemo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import coil.annotation.ExperimentalCoilApi
import com.hayde117.roomdemo.data.Person
import com.hayde117.roomdemo.screens.add.AddScreen
import com.hayde117.roomdemo.screens.edit.EditScreen
import com.hayde117.roomdemo.screens.list.ListScreen
import com.hayde117.roomdemo.screens.search.SearchScreen
import com.hayde117.roomdemo.utils.Constants
import kotlin.reflect.typeOf

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.List) {

        composable<Screens.List> {
            ListScreen(
                navController = navController,
            )
        }

        composable<Screens.Add> {
            AddScreen(
                navController = navController,
            )
        }

        composable<Screens.Edit>(
            typeMap = mapOf(
                typeOf<Person>() to Constants.CustomNavType<Person>(
                    Person::class,
                    Person.serializer()
                ))
        ) {
            val myArguments = it.toRoute<Screens.Edit>()

            EditScreen(
                navController = navController,
                navPerson = myArguments
            )
        }

        composable<Screens.Search> {
            SearchScreen(
                navController = navController,
            )
        }

    }
}

val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED

