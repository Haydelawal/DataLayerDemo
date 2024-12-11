package com.hayde117.roomdemo.screens.edit

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hayde117.roomdemo.data.Person
import com.hayde117.roomdemo.presentation.common.PersonForm

@Composable
fun EditContent(
    modifier: Modifier = Modifier,
    onAddOrUpdateClick: (Person) -> Unit,
    updatePerson: Boolean,
    person: Person?,
    closeScreenAndNavigateBack : () -> Unit
) {

    PersonForm(
        modifier = modifier,
        onAddOrUpdateClick = onAddOrUpdateClick, updatePerson = updatePerson, person = person,
        closeScreenAndNavigateBack = closeScreenAndNavigateBack
    )
}