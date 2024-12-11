package com.hayde117.roomprepopulatedemo.screens.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hayde117.roomprepopulatedemo.data.Person
import com.hayde117.roomprepopulatedemo.presentation.common.EmptyContent
import com.hayde117.roomprepopulatedemo.presentation.common.ListItem

@Composable
fun ListContent(
    items: List<Person>,
    modifier: Modifier = Modifier,
    onClick: (Person) -> Unit
) {
    if (items.isEmpty()) {
        EmptyContent()
    } else {
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


}
