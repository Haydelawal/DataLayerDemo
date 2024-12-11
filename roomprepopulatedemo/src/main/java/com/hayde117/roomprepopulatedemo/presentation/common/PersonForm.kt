package com.hayde117.roomprepopulatedemo.presentation.common

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hayde117.roomprepopulatedemo.R
import com.hayde117.roomprepopulatedemo.data.Person
import com.hayde117.roomprepopulatedemo.ui.theme.DataLayerDemoTheme

@Composable
fun PersonForm(
    modifier: Modifier = Modifier,
    onAddOrUpdateClick: (Person) -> Unit,
    updatePerson: Boolean,
    person: Person?,
    closeScreenAndNavigateBack: () -> Unit
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val id by rememberSaveable { mutableStateOf(person?.id ?: 0) }
        var firstName by rememberSaveable { mutableStateOf(person?.firstName ?: "") }
        var lastName by rememberSaveable { mutableStateOf(person?.lastName ?: "") }
        var middleName by rememberSaveable { mutableStateOf(person?.middleName ?: "") }
        var gender by rememberSaveable { mutableStateOf(person?.gender ?: "") }
        var age by rememberSaveable { mutableStateOf(person?.age ?: "") }

        val myPerson = Person(
            id = id,
            firstName = firstName,
            middleName = middleName,
            lastName = lastName,
            gender = gender,
            age = age,
        )

        val focusManager = LocalFocusManager.current

        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.first_name)) },
            value = firstName,
            onValueChange = { firstName = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.middle_name)) },
            value = middleName,
            onValueChange = { middleName = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.last_name)) },
            value = lastName,
            onValueChange = { lastName = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.gender)) },
            value = gender,
            onValueChange = { gender = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.age)) },
            value = age,
            onValueChange = { age = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                    Toast.makeText(context, "Ready to submit!", Toast.LENGTH_SHORT).show()
                }
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(modifier = modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth(), onClick = {

            // show dialog
            if (updatePerson) {
                onAddOrUpdateClick(myPerson)

                Toast.makeText(context, "Updated $firstName $lastName", Toast.LENGTH_SHORT).show()
                // navigate back
                closeScreenAndNavigateBack()

            } else {
                Toast.makeText(context, "Added $firstName $lastName", Toast.LENGTH_SHORT).show()
                onAddOrUpdateClick(myPerson)
                // navigate back
                closeScreenAndNavigateBack()
            }

        }) {
            Text(
                text = if (updatePerson) stringResource(id = R.string.update) else stringResource(id = R.string.add)
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun MyFormLayoutPreview() {
    DataLayerDemoTheme {
        PersonForm( onAddOrUpdateClick = {}, updatePerson = true, person = null, closeScreenAndNavigateBack = {})
    }
}