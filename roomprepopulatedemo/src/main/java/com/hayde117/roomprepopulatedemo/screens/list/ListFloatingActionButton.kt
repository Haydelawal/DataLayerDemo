package com.hayde117.roomprepopulatedemo.screens.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hayde117.roomprepopulatedemo.R

@Composable
fun ListFloatingActionButton(
    modifier: Modifier = Modifier,
    onFabClicked: () -> Unit

) {

    Column(modifier = Modifier
        .wrapContentSize(Alignment.Center)
        .size(50.dp)
        .clickable {
            onFabClicked()
        }
    ) {
        Icon(
            modifier = modifier.fillMaxSize(),
            painter = painterResource(R.drawable.add_circle),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
@Preview
fun ListFloatingActionButtonPreview() {
    ListFloatingActionButton(onFabClicked = {})
}