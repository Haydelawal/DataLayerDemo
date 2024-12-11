package com.hayde117.roomdemo.screens.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.hayde117.roomdemo.navigation.canGoBack

@ExperimentalCoilApi
@Composable
fun SearchScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            SearchWidget(
                text = "searchQuery",
                onTextChange = {
/*
                    searchViewModel.updateSearchQuery(query = it)
*/
                },
                onSearchClicked = {
                },
                onCloseClicked = {
                    if (navController.canGoBack){ navController.popBackStack() }

                }
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        content = { padding ->
//            ListContent(items = searchedImages, modifier = Modifier.padding(padding))

            ScreenContent(items = emptyList(), onClick = {}, modifier = modifier.padding(padding))
        }
    )

}
