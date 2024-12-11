package com.hayde117.retrofitdemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hayde117.retrofitdemo.home_screen.ListScreen
import com.hayde117.retrofitdemo.viewmodel.MyViewModel
import com.hayde117.retrofitdemo.ui.theme.DataLayerDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // most likely you wont do this in real project
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DataLayerDemoTheme {

                // most likely you wont do this in real project
                val isConnected by myViewModel.isConnected.collectAsStateWithLifecycle()

                val context = LocalContext.current
                Toast.makeText(context, "I am $isConnected", Toast.LENGTH_SHORT).show()

                if (isConnected) {
                    // call api
                    myViewModel.fetchApiResult()}
                else{
                    Log.d("no internet", "onCreate: dont")
                }
                ListScreen()

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DataLayerDemoTheme {
        Greeting("Android")
    }
}