package com.example.webviewapp.ui.screen.connection_error

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.webviewapp.Constants
import com.example.webviewapp.R
import com.example.webviewapp.ui.theme.MyTheme

@Composable
fun ConnectionErrorScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MyTheme.colors.primary.white),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_connection_error),
            contentDescription = null,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = stringResource(id = R.string.connection_error_title),
            style = MyTheme.typography.title.title_large.copy(
                color = MyTheme.colors.primary.dark
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.connection_error_subtitle),
            style = MyTheme.typography.body.body_medium.copy(
                color = MyTheme.colors.secondary.dark
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Button(
            modifier = Modifier
                .padding(16.dp),
            onClick = {
                navController.navigate(Constants.WEB_VIEW_ROUTE)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MyTheme.colors.primary.pink
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.connection_error_button),
                style = MyTheme.typography.body.body_medium
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenPreview() {
    ConnectionErrorScreen(navController = rememberNavController())
}