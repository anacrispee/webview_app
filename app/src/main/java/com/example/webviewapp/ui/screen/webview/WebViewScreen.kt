package com.example.webviewapp.ui.screen.webview

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.webviewapp.Constants.URL_BASE

@Composable
fun WebViewScreen(
    viewModel: WebViewViewModel
) {
    val viewState = WebViewViewState()
    val action = viewModel::dispatcherAction
    val context = LocalContext.current

    LaunchedEffect(true) {
        if (isNetworkAvailable(context).not()) {
            action(WebViewViewAction.GoToConnectionErrorScreen)
        }
        return@LaunchedEffect
    }

    if (viewState.isLoading) {
        LoadingScreen()
        return
    }

    AndroidView(
        factory = {
            WebView(it).apply {
                webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean {
                        val shouldOverloadUrl = true
                        if (isNetworkAvailable(context).not()) {
                            action(
                                WebViewViewAction.GoToConnectionErrorScreen
                            )
                            return shouldOverloadUrl
                        }
                        return super.shouldOverrideUrlLoading(view, request)
                    }
                }

                webChromeClient = object : WebChromeClient() {

                    override fun onShowFileChooser(
                        webView: WebView?,
                        filePathCallback: ValueCallback<Array<Uri>>?,
                        fileChooserParams: FileChooserParams?,
                    ): Boolean {
                        return super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
                    }
                }

                settings.loadWithOverviewMode = true
                settings.mediaPlaybackRequiresUserGesture = false
                settings.setSupportMultipleWindows(true)
                settings.javaScriptCanOpenWindowsAutomatically = true
                settings.allowFileAccess = true
                settings.domStorageEnabled = true
                settings.allowContentAccess = true
            }
        },
        update = { webView ->
            webView.loadUrl(URL_BASE)
        }
    )
}

@Composable
fun LoadingScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

private fun isNetworkAvailable(context: Context) : Boolean =
    (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
        getNetworkCapabilities(activeNetwork)?.run {
            hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                    || hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    || hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        }
    } ?: false
