package com.hayde117.retrofitdemo.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hayde117.retrofitdemo.model.MyPost

@Composable
fun ListItem(myPost: MyPost, modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Text(text = myPost.title.toString())
        Text(text = myPost.myUserId.toString())
        Text(text = myPost.body.toString())
        Text(text = myPost.id.toString())
    }

}