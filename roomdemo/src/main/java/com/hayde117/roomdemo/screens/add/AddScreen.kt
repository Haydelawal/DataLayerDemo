package com.hayde117.roomdemo.screens.add

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hayde117.roomdemo.navigation.canGoBack

@Composable
fun AddScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    addViewModel: AddViewModel = hiltViewModel(),
) {

    Scaffold(
        topBar = {
            AddTopAppBar(
                onBackPressed = {
                    if (navController.canGoBack) {
                        navController.popBackStack()
                    }
                }
            )
        },

        content = { paddingValues ->
            AddContent(
                modifier = modifier.padding(paddingValues),
                onAddOrUpdateClick = { person ->
                    addViewModel.insertData(person)
                },
                updatePerson = false, person = null,
                closeScreenAndNavigateBack = {
                    if (navController.canGoBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    )

}