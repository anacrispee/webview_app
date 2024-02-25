package com.example.webviewapp.ui.screen.connection_error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.webviewapp.Constants
import com.example.webviewapp.R

@Composable
fun ConnectionErrorScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.connection_error_title))
        Text(text = stringResource(id = R.string.connection_error_subtitle))
        Button(onClick = {
            navController.navigate(Constants.WEB_VIEW_ROUTE)
        }) {
            Text(text = stringResource(id = R.string.connection_error_button))
        }
    }
}