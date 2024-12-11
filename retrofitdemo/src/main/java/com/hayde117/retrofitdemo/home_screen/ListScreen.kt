package com.hayde117.retrofitdemo.home_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hayde117.retrofitdemo.viewmodel.MyViewModel

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    myViewModel: MyViewModel = hiltViewModel()
) {

    val myResponseFlow by myViewModel.myResponseFlow.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {},
        floatingActionButton = {},
        content = { paddingValues ->
            ListContent(
                items = myResponseFlow,
                modifier = modifier.padding(paddingValues)
            )
        }
    )
}

@Composable
@Preview
fun ListScreenPreview() {
//    ListScreen()
}