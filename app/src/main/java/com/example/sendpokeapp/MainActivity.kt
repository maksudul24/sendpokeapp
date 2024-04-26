package com.example.sendpokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sendpokeapp.ui.theme.SendPokeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(loginHandler = { username, password ->
                // Call your login function here with username and password
                performLogin(username, password)
            })
        }
    }
    private fun performLogin(username: String, password: String) {
        // Check if username and password are valid
        if (isValidCredentials(username, password)) {
                setContent{
                    UserHome()
                }
        } else {
            Log.d("Tag", "User Name and Password is Not Valid")
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        return username == "admin" && password == "admin"
    }

}
