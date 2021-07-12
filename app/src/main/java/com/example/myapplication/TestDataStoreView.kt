
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.asLiveData
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.runBlocking

class TestDataStoreView : ComponentActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column{

                        Greeting("Android")
                        Button(onClick = {
                            clickApi()
                        }) {
                            Text("Click API")
                        }
                    }
                }
            }
        }
    }
    private fun clickApi() {
        runBlocking {
            saveAuthToken("123456")
        }
    }
    suspend fun saveAuthToken(token: String) {
        UserPreferences(this).saveAuthToken(token)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}