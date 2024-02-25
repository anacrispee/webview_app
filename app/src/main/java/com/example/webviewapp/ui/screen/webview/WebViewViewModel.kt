package com.example.webviewapp.ui.screen.webview

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.webviewapp.Constants.CONNECTION_ERROR_ROUTE

class WebViewViewModel(
    private var navController: NavController
) : ViewModel() {
    fun dispatcherAction(action: WebViewViewAction) {
        when (action) {
            WebViewViewAction.GoToConnectionErrorScreen -> navController.navigate(CONNECTION_ERROR_ROUTE)
        }
    }
}