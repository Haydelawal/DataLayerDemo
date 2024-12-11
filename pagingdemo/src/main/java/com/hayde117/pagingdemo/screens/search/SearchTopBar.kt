package com.hayde117.pagingdemo.screens.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
/** this doesnt search on text change as you type in search bar **/
//fun SearchWidget(
//    text: String,
//    onTextChange: (String) -> Unit,
//    onSearchClicked: (String) -> Unit,
//    onCloseClicked: () -> Unit
//) {
//    Surface(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(56.dp)
//            .semantics {
//                contentDescription = "SearchWidget"
//            },
//        tonalElevation = 4.dp, // Material 3 elevation
//        color = TopAppBarDefaults.topAppBarColors().containerColor
//    ) {
//        TextField(
//            modifier = Modifier
//                .fillMaxWidth()
//                .semantics {
//                    contentDescription = "TextField"
//                },
//            value = text,
//            onValueChange = { onTextChange(it) },
//            placeholder = {
//                Text(
//                    modifier = Modifier
//                        .alpha(alpha = 0.5f),
//                    text = "Search here...",
//                    color = Color.White
//                )
//            },
//            textStyle = TextStyle(
//                color = MaterialTheme.colorScheme.onSurface // Use onSurface for text color
//            ),
//            singleLine = true,
//            leadingIcon = {
//                IconButton(
//                    modifier = Modifier
//                        .alpha(alpha = 0.5f),
//                    onClick = {}
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = "Search Icon",
//                        tint = MaterialTheme.colorScheme.onSurface
//                    )
//                }
//            },
//            trailingIcon = {
//                IconButton(
//                    modifier = Modifier
//                        .semantics {
//                            contentDescription = "CloseButton"
//                        },
//                    onClick = {
//                        if (text.isNotEmpty()) {
//                            onTextChange("")
//                        } else {
//                            onCloseClicked()
//                        }
//                    }
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Close,
//                        contentDescription = "Close Icon",
//                        tint = MaterialTheme.colorScheme.onSurface
//                    )
//                }
//            },
//            keyboardOptions = KeyboardOptions(
//                imeAction = ImeAction.Search
//            ),
//            keyboardActions = KeyboardActions(
//                onSearch = {
//                    onSearchClicked(text)
//                }
//            ),
//            colors = TextFieldDefaults.colors(
//                cursorColor = MaterialTheme.colorScheme.onSurface,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent,
//                )
//        )
//    }
//}

/** this changes results on text change as you type in search bar
 * take it easy with this particular impl as the api has a daily limit
 * and you wont want to max your quota**/

fun SearchWidget(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,  // You may still keep this for manual search
    onCloseClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shadowElevation = 8.dp
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    contentDescription = "TextField"
                },
            value = text,
            onValueChange = {
                onTextChange(it)  // This triggers the search function automatically
            },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(alpha = 0.5f),
                    text = "Search here...",
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onSurface
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(alpha = 0.5f),
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    modifier = Modifier
                        .semantics {
                            contentDescription = "CloseButton"
                        },
                    onClick = {
                        if (text.isNotEmpty()) {
                            onTextChange("")  // Clear text on close icon click
                        } else {
                            onCloseClicked()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)  // You can still handle manual search on enter if needed
                }
            ),
            colors = TextFieldDefaults.colors(
                cursorColor = MaterialTheme.colorScheme.onSurface,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}


@Composable
@Preview
fun SearchWidgetPreview() {
    SearchWidget(
        text = "Search",
        onTextChange = {},
        onSearchClicked = {},
        onCloseClicked = {}
    )
}