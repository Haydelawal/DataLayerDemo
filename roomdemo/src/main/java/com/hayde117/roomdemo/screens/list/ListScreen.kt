package com.hayde117.roomdemo.screens.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.hayde117.roomdemo.navigation.Screens

@Composable
fun ListScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    listViewModel: ListViewModel = hiltViewModel()
) {

    val personsList by listViewModel.allPersons.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            ListTopAppBar(onSearchClicked = {
                navController.navigate(Screens.Search)
            },
                onDeleteAllClicked = {})
        },
        floatingActionButton = {
            ListFloatingActionButton(onFabClicked = {
                navController.navigate(Screens.Add)
            })
        },
        floatingActionButtonPosition = FabPosition.End,
        content = { paddingValues ->
            ListContent(
                items = personsList,
                modifier = modifier.padding(paddingValues),
                onClick = { person ->
                    navController.navigate(
                        Screens.Edit(person)
                    )
                }
            )
        }
    )
}

@Composable
@Preview
fun ListScreenPreview() {
//    ListScreen()
}