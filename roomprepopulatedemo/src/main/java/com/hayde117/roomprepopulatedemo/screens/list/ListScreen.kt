package com.hayde117.roomprepopulatedemo.screens.list

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

@Composable
fun ListScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    listViewModel: ListViewModel = hiltViewModel()
) {

    val personsList by listViewModel.allPersons.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            ListTopAppBar(onSearchClicked = {},
                onDeleteAllClicked = {})
        },
        floatingActionButton = {
            ListFloatingActionButton(onFabClicked = {})
        },
        floatingActionButtonPosition = FabPosition.End,
        content = { paddingValues ->
            ListContent(
                items = personsList,
                modifier = modifier.padding(paddingValues),
                onClick = { person ->
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