package com.example.webviewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.webviewapp.ui.screen.connection_error.ConnectionErrorScreen
import com.example.webviewapp.ui.screen.webview.WebViewScreen
import com.example.webviewapp.ui.screen.webview.WebViewViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel = WebViewViewModel(navController = navController)
            NavHost(
                navController = navController,
                startDestination = Constants.WEB_VIEW_ROUTE
            ) {
                composable(route = Constants.WEB_VIEW_ROUTE) { WebViewScreen(viewModel = viewModel) }
                composable(route = Constants.CONNECTION_ERROR_ROUTE) { ConnectionErrorScreen(navController = navController) }
            }
        }
    }
}