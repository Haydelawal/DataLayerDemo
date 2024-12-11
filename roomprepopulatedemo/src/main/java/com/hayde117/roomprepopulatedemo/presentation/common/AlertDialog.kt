package com.hayde117.roomprepopulatedemo.presentation.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.hayde117.roomprepopulatedemo.ui.theme.DataLayerDemoTheme

@Composable
fun DisplayAlertDialog(
    title: String,
    message: String,
    dialogOpened: Boolean,
    onDialogClosed: () -> Unit,
    onYesClicked: () -> Unit,
){
    if (dialogOpened){
        AlertDialog(
            title = {
                Text(text = title, fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.Bold)
            },
            text = {
                Text(text = message, fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Normal)
            },
            confirmButton = {
                Button(onClick = {
                    onYesClicked()
                    onDialogClosed()
                }) {
                    Text(text = "Yes")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = onDialogClosed) {
                    Text(text = "NO")
                }
            },
            onDismissRequest = onDialogClosed
            
        
        ) 
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayAlertDialogPreview() {
    DataLayerDemoTheme {
        DisplayAlertDialog(
            title = "mattis",
            message = "convallis",
            dialogOpened = true,
            onDialogClosed = {},
            onYesClicked = {})
    }
}