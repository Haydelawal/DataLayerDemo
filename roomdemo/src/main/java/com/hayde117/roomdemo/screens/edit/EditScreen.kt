package com.hayde117.roomdemo.screens.edit

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hayde117.roomdemo.navigation.Screens
import com.hayde117.roomdemo.navigation.canGoBack

@Composable
fun EditScreen(
    navPerson: Screens.Edit,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    editViewModel: EditViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            EditTopAppBar(
                onBackPressed = {
                    if (navController.canGoBack) {
                        navController.popBackStack()
                    }
                },
                onDeleteClicked = {
                        editViewModel.deleteData(navPerson.person)

                    if (navController.canGoBack) {
                        navController.popBackStack()
                    }
                }
            )
        },

        content = { paddingValues ->
            EditContent(
                modifier = modifier.padding(paddingValues),
                onAddOrUpdateClick = { person ->
                    editViewModel.updateData(person)
                },
                updatePerson = true,
                person = navPerson.person,
                closeScreenAndNavigateBack = {
                    if (navController.canGoBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    )

}