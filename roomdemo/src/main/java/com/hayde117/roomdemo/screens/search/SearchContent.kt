package com.hayde117.roomdemo.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hayde117.roomdemo.data.Person
import com.hayde117.roomdemo.presentation.common.ListItem

@Composable
fun ScreenContent(
    items: List<Person>, modifier: Modifier = Modifier,
    onClick: (Person) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = items,
            key = { it.id }
        ) {
            ListItem(person = it, onClick = onClick)
        }
    }
}
