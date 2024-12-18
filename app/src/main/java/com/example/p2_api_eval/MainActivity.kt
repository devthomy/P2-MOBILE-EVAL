package com.example.p2_api_eval

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.example.p2_api_eval.ui.navigation.AppNavGraph
import com.example.p2_api_eval.ui.theme.AppTheme

/*
* Main qui est run
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember { mutableStateOf(true) }

            AppTheme(darkTheme = isDarkTheme) {
                val navController = rememberNavController()
                AppNavGraph(
                    navController = navController,
                    onToggleTheme = {
                        isDarkTheme = !isDarkTheme
                    },
                    language = "fr"
                )
            }
        }
    }
}