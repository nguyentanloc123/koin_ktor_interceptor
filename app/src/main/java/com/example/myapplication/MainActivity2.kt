package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column{
                        Greeting("Android")
                        Button(onClick = {
                            somethingUsefulOneAsync()
                        }) {
                            Text("Button")
                        }
                    }
                }
            }
        }
    }
    suspend fun saveAuthToken(token: String) {
        UserPreferences(this).saveAuthToken(token)
    }
    suspend fun authToken() {
        UserPreferences(this).authToken
    }
    private fun somethingAuthToken() {
        GlobalScope.launch{
            authToken()
        }
    }
    private fun somethingUsefulOneAsync() {
        GlobalScope.launch{
            saveAuthToken("1233113")
        }
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