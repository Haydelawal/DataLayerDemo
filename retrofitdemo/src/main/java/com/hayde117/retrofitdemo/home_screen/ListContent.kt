package com.hayde117.retrofitdemo.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hayde117.retrofitdemo.model.MyPost
import com.hayde117.retrofitdemo.utils.NetworkResult

@Composable
fun ListContent(
    items: NetworkResult<MyPost>,
    modifier: Modifier = Modifier,
) {

    val data = listOf(items.data)

    when (val result = items) {
        is NetworkResult.Success -> {
            // Show success UI
//            Text(text = "Data: ${result.data}")
            val myData = listOf(result.data)

            if (myData.isEmpty()) {
                EmptyContent()
            } else {
                LazyColumn(
                    modifier = modifier.fillMaxSize(),
                    contentPadding = PaddingValues(all = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(
                        items = data,
                        key = { it!!.myUserId }
                    ) {
                        ListItem(modifier = modifier, myPost = it!!)
                    }
                }
            }

        }

        is NetworkResult.Error -> {
            // Show error UI

            Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Error: ${result.message}")
            }
        }

        is NetworkResult.Loading -> {
            // Show loading UI
            Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator()
            }
        }
    }


}
