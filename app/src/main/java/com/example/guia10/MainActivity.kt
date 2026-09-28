package com.example.guia10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.guia10.navigation.AppNavigation
import com.example.guia10.ui.theme.Guia10Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Guia10Theme {
                AppNavigation()
            }
        }
    }
}